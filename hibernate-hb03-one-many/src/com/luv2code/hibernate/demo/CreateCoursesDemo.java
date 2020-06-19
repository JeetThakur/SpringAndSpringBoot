package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			
			// create some courses
			Course tempCourse1 = new Course("Algorithms");
			Course tempCourse2 = new Course("Java");
	
			// extra course to not add
			Course tempCourse3 = new Course("Painting");
			
			// add the course to the instructor
			inst.addCourse(tempCourse1);
			inst.addCourse(tempCourse2);
		
			
			// save the courses 
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			// commit the transaction
			session.getTransaction().commit();
			
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
