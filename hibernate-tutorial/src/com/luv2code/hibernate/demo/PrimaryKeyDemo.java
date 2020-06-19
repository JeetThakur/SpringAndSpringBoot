package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;


public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create a session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// Create a session
				Session session = factory.getCurrentSession();
				
				try {
					
					// creating 3 new student
					System.out.println("Creating a new student:- \n");
					Student newStudent1 = new Student("MogoJogo", "Gowda", "mgj9270@rit.edu");
					Student newStudent2 = new Student("Sam", "Sarvaiya", "sss9170@rit.edu");
					Student newStudent3 = new Student("Dhrumil", "Mehta", "dm9370@rit.edu");
					
					// begin trans
					System.out.println("Begining Transaction: \n");
					session.beginTransaction();
					
					// saving the student
					System.out.println("Saving the student: \n");
					session.save(newStudent1);
					session.save(newStudent2);
					session.save(newStudent3);
					
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
