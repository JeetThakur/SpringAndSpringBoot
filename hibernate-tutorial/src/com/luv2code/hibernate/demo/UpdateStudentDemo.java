package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		// create a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			// Session created
			session = factory.getCurrentSession();
			
			// new transaction 
			session.beginTransaction();
			
			// retreive based on id - prim key
			Student myStudent = session.get(Student.class, studentId);
			
			
			// New Stuff
			
			// Updating student
			System.out.println("\nUpdating the student\n");
			myStudent.setFirstName("ScoobyDoo");
			
			// Commit the transaction
			session.getTransaction().commit();
			
			
			
			// new Session
			session = factory.getCurrentSession();
			// Begin trans
			session.beginTransaction();
			
			
			// bulk updates email for all students : thisIsGood@gmail.com
			session.createQuery("update Student set email='thisIsGood@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			// new Session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for lastName = Thakur to ThisIsThakur@gmail.com
			session.createQuery("update Student s set email='ThisIsThakur@gmail.com' where s.lastName='Thakur'").executeUpdate();
			
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
