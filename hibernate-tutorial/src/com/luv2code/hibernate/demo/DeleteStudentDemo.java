package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			//	Option 1 - Retrieve and delete
			
			int studentId = 2;
			// Retreive the student from the database
			// now get a new session
			session = factory.getCurrentSession();
			// new transaction 
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Got Complete: " + myStudent);
			
			
			// Now delete
			System.out.println("\nDeleting the student\n");
			session.delete(myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			
			
			// Option 2 - Delete on the fly
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Deleting using a query
			session.createQuery("delete from Student where id=5").executeUpdate();
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
