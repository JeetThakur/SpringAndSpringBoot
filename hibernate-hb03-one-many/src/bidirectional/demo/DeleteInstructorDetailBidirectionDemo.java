package bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class DeleteInstructorDetailBidirectionDemo {

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
			int theId = 3;
			InstructorDetail insD = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail object
			System.out.println("\ntempInstructorDetail: " + insD);
			
			
			// New stuff only when we want to delete the detail but not the instructor
			// breaking the 2 way link -- to savely go through delete the detail and keep the instructor
			// This way the foreign key value is set to null
			insD.getInstructor().setInstructorDetail(null);
			
			
			
			// delete the object
			session.delete(insD);
			System.out.println("Deleted the object");
			
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
