package com.luv2code.DemoApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Employee;

public class Activity8Demo {

	public static void main(String[] args) {
		
		// create factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// get session
			session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			// try adding a few employees
			Employee tempEmp1 = new Employee("Jeet", "Thakur", "Amazon");
			Employee tempEmp2 = new Employee("Jeet", "Thakur", "Apple");
			Employee tempEmp3 = new Employee("Jeet", "Thakur", "GS");
			Employee tempEmp4 = new Employee("Jeet", "Thakur", "RBS");
			Employee tempEmp5 = new Employee("Jeet", "Thakur", "Palantir");
			
			// save data
			session.save(tempEmp1);
			session.save(tempEmp2);
			session.save(tempEmp3);
			session.save(tempEmp4);
			session.save(tempEmp5);
			
			// commit
			session.getTransaction().commit();
			System.out.println("Saving Done!");
			// Retrieve data
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// by prim key
			int empId = 1;
			
			Employee e = session.get(Employee.class, empId);
			
			System.out.println("\nEmployee found at #1:- \n" + e);
			
			session.getTransaction().commit();
			
			// by entire query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Employee> empList = session.createQuery("from Employee e where e.company='GS'").getResultList();
			
			// display the results:
			displayEmployee(empList);
			
			session.getTransaction().commit();
			
			// Deleting an object
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			session.createQuery("delete from Employee e where e.company='Palantir'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("\nPost delete:\n");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			empList = session.createQuery("from Employee").getResultList();
			
			// display the results:
			displayEmployee(empList);
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployee(List<Employee> empList) {
		for (Employee eTemp: empList) {
			System.out.println(eTemp);
		}
	}
}
