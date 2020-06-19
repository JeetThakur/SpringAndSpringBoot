package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// begin trans
			System.out.println("Begining Transaction: \n");
			session.beginTransaction();
			
	
			// Query1]  on the records
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			
			// display the students -- list of objects
			displayStudents(theStudent);
			
			
			// Query2 ]  lastName='thakur'
			theStudent = session.createQuery("from Student s where s.lastName='Thakur'").getResultList();
			

			// display the students -- list of objects
			System.out.println("\n Students with lastName as thakur: \n");
			displayStudents(theStudent);
			
			
			// Query 3] lastName=Thakur or firstName='mogo'
			theStudent = session.createQuery("from Student s where s.lastName='Thakur'" + "OR s.firstName='Mogo'").getResultList();
			
			// display the students -- list of objects
			System.out.println("\nGetting the result for the Or query:\n");
			displayStudents(theStudent);
			
			
			// Query 4] Like clause email ends with rit.edu
			theStudent = session.createQuery("from Student s where s.email LIKE '%rit.edu'").getResultList();
			

			// display the students -- list of objects
			System.out.println("\nGetting the result for Like clause\n");
			displayStudents(theStudent);
			
			
			// commit the transaction
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

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
