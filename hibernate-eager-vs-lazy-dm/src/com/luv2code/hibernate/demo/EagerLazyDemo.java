package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
		
			// begin transaction	
			session.beginTransaction();
			
			
			// get the instructor from db
			int instId = 1;
			Instructor inst = session.get(Instructor.class, instId);
			
			System.out.println("Our Instructor: " + inst);
			

			// This should now fail-- lAZY LOADING ISSUE FAIL SOLUTION COMING DOWN
			System.out.println("Our Courses: " + inst.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			//CLOSE SESSION
			session.close();
			
			// This broke earlier ... we copy pasted it back again in the code before session was closed
			System.out.println("Our Courses: " + inst.getCourses());
			
			System.out.println("Done!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
