package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scope-applicationContext.xml");
		
		// Retrieve the beans from the container 
		CoachInterface theCoach =  context.getBean("myCoach", CoachInterface.class);
		
		// The second one pointing on the same bean
		CoachInterface theAlphaCoach = context.getBean("myCoach", CoachInterface.class);
		
		// Check to see if they both are the same beans or not 
		boolean result = (theCoach == theAlphaCoach);
		
		System.out.println("\nare they the same ?? : " + result);
		System.out.println("\nThe mem location for theCoach: " + theCoach);
		System.out.println("\nThe mem location for theCoach: " + theAlphaCoach);
		
		
		
//		// Now testing scope prototype 
//		System.out.println("\nNow using prototype");
//		
//		// To do this make change in appContext making the scope = prototype
//		// Check to see if they both are the same beans or not 
//		boolean result2 = (theCoach == theAlphaCoach);
//		
//		System.out.println("\nare they the same ?? :-" + result2);
//		System.out.println("\nThe mem location for theCoach:- " + theCoach);
//		System.out.println("\nThe mem location for theCoach:- " + theAlphaCoach);
//		// close the context
		
		context.close();
	}

}
