package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class FetchJoinDemo {

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
			
			// Hibernate Query  option 2
			
			
			
			// get the instructor from db
			int instId = 1;
			
			
			// HQL Query
			Query<Instructor> query = session.createQuery("select i from Instructor i "+ "JOIN FETCH i.courses " + "where i.id=:theInstructorId ",  Instructor.class);
			
			// set param
			query.setParameter("theInstructorId", instId);
			
			Instructor inst = query.getSingleResult();
			System.out.println("Our Instructor: " + inst);
			
			
			System.out.println("Our Courses: " + inst.getCourses());
			// commit the transaction
			session.getTransaction().commit();
			
			
			//CLOSE SESSION
			session.close();
			
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
