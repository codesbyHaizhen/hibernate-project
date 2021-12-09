package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryStudentDemo {

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
			
			// query students 
			List<Student> theStudents = session
										.createQuery("from Student s where s.firstName='Anna'")
										.getResultList();
			
			for (Student tempStudent : theStudents) 
				System.out.println(tempStudent);
			
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
