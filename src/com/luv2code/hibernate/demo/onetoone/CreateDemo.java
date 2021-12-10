package com.luv2code.hibernate.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate_onetoone.cfg.xml")
									.addAnnotatedClass(Teacher.class)
									.addAnnotatedClass(TeacherDetail.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Teacher tempTeacher = new Teacher("Anna", "Muster","anna.muster@hotmail.com");
			
			TeacherDetail tempTeacherDetail = new TeacherDetail("http://www.anna-muster.net","dance");
			
			// associate the objects
			tempTeacher.setTeacherDetail(tempTeacherDetail);
			
			// start a transaction
			System.out.println("start the transcaction...");
			session.beginTransaction();
			
			// save the object, this will also save the Detail object
			// because of CascadeType.ALL
			System.out.println("save the object");
			session.save(tempTeacher);
			
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
