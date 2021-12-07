package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			
			// create a Student object
			Student tempStudent = new Student("Anna", "Muster","anna.muster@hotmail.com");
			
			// start a transaction
			System.out.println("start the transcaction...");
			session.beginTransaction();
			
			// save the Student object 
			System.out.println("save the object");
			session.save(tempStudent);
			
			// commit transaction	
			System.out.println("commit the transaction");
			session.getTransaction().commit();
			
			System.out.println("ready");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		

	}

}
