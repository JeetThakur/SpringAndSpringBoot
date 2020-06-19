package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// Load the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		CoachInterface theCoach = context.getBean("myCoach" , CoachInterface.class);
		
		// Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.print(theCoach.getDailyFortune());
		
		// Close the context
		context.close();
	}

}
