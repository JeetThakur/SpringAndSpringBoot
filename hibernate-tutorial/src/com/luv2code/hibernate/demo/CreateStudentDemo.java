package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class CreateStudentDemo {

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
			Student newStudent = new Student("Jeet", "Thakur", "jbt9370@rit.edu");
		
			// begin trans
			System.out.println("Begining Transaction: \n");
			session.beginTransaction();
			
			// saving the student
			System.out.println("Saving the student: \n");
			session.save(newStudent);
			
			// commit the transaction
			System.out.println("Commiting the record: \n");
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
