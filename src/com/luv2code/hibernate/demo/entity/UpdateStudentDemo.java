package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			System.out.println("start the transcaction...");
			session.beginTransaction();
			
			int studentId = 2;
			
			// retrieve object from database
			Student myStudent = session.get(Student.class, studentId);
			
			// update the object's attribute
			myStudent.setFirstName("Franziska");
			
			// commit transaction	
			System.out.println("commit the transaction");
			session.getTransaction().commit();
			
			// get a new session
			session = factory.getCurrentSession();
			
			// start a transaction
			session.beginTransaction();
			
			// update all object's attribute
			session.createQuery("update Student set email='foo@hotmail.de'")
					.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		

	}

}
