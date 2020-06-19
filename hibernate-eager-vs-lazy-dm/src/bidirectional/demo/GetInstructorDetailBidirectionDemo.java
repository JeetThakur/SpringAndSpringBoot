package bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class GetInstructorDetailBidirectionDemo {

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
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail insD = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail object
			System.out.println("\ntempInstructorDetail: " + insD);
			
			
			// print the associated instructor
			System.out.println("\nThe associated Instructor: " + insD.getInstructor());
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle collection leak
			session.close();
			factory.close();
		}
	}

}
