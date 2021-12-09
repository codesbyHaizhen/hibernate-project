package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to read java object
			
			// create a Student object
			Student tempStudent = new Student("Johanna", "Muster","johanna.muster@hotmail.com");
			
			// start a transaction
			System.out.println("start the transcaction...");
			session.beginTransaction();
			
			// save the Student object 
			System.out.println("save the object");
			session.save(tempStudent);
			
			// commit transaction	
			System.out.println("commit the transaction");
			session.getTransaction().commit();
			
			// get a new session
			System.out.println("create a new session...");
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			System.out.println("start the transaction");
			
			// read Student object from database 
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("retrieve data from database");
			// Student myStudent = session.get(Student.class, 2);
			
			session.getTransaction().commit();
			System.out.println("commit the transaction");
			
			System.out.println("ready");
			System.out.println("Student: " + tempStudent);
			System.out.println("Student in the database: " + myStudent);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		

	}

}
