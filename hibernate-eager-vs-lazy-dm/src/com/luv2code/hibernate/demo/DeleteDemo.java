package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class DeleteDemo {

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
			session = factory.getCurrentSession();
			
			// begin transaction	
			session.beginTransaction();
						
			// Get Inst by prim Id or key
			int theId= 1;
			Instructor ins = session.get(Instructor.class, theId);
			
			// Delete by the id
			if (ins !=null) { // check if not null 
				session.delete(ins); // deleting the instructor -- Note since cascade.all it will also delete the details object of the second table
			}
			
			
			
			
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
