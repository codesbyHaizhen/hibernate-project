package com.luv2code.hibernate.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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
			
			int teacherId = 1;
			
			// start a transaction
			System.out.println("start the transcaction...");
			session.beginTransaction();
			
			// get object with primary key
			Teacher tempTeacher = session.get(Teacher.class, teacherId);
			
			if (tempTeacher != null) {
				// delete this object, will also delete the associated detail object
				// because of CascadeType.ALL
				session.delete(tempTeacher);
			}
			
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
