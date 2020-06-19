package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// creating new student
			System.out.println("Creating a new student:- \n");
			Student newStudent = new Student("Daffy", "Duck", "daffy@rit.edu");
		
			// begin trans
			System.out.println("Begining Transaction: \n");
			session.beginTransaction();
			
			// saving the student
			System.out.println("Saving the student: \n");
			System.out.println(newStudent);
			session.save(newStudent);
			
			// commit the transaction
			System.out.println("Commiting the record: \n");
			session.getTransaction().commit();
			
			
			
			// NEW STUFF BASED ON READ FUNCTION
			
			
			// FIND OUT THE ID : PRIM KEY
			System.out.println("Saved Student. Generate id: " + newStudent.getId());

			
			
			
			
			
			// Retreive the student from the database
			
			// now get a new session
			session = factory.getCurrentSession();
			
			// new transaction 
			session.beginTransaction();
			
			// retreive based on id - prim key
			System.out.println("\nGetting student with id: " + newStudent.getId());
			
			Student myStudent = session.get(Student.class, newStudent.getId());
			
			System.out.println("Got Complete: " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
