package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// creating new objects
			Instructor tempIns = new Instructor("Soumil", "Sarvaiya", "ss9370@rit.edu");
			InstructorDetail tempInsD = new InstructorDetail("http://www.fake22.com/youtube", "luv2code!yes?maybe!");
			
			
			// associate the objects -- referential integrity 
			tempIns.setInstructorDetail(tempInsD);
			
		
			// begin transaction	
			session.beginTransaction();
			
			// Save
			// Note this will also save the tempInstD as it is cascaded .. since we have used cascade.All
			// Otherwise we will have to write similar code snippet to save the other integrity
			session.save(tempIns);
		
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

}
