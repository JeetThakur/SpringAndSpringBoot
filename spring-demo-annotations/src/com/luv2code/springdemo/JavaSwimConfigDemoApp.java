package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaSwimConfigDemoApp {

	public static void main(String[] args) {

		// Read the Java Config file now -- NO XML REQUIRED
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySportConfig.class);
		
		// read the bean -- getting the object created by spring
		//Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// For the activity to use @Value
		JumpCoach theSwimCoach = context.getBean("jumpCoach", JumpCoach.class);
		
		
		
		// get methods
		System.out.println("The Swim coach :- " + theSwimCoach.getDailyWorkout());
		
		// get the daily fortune method
		System.out.println(theSwimCoach.getDailyFortune());
		System.out.println(theSwimCoach.getEmail());
		System.out.println(theSwimCoach.getTeam());
		
		// clean the bean
		context.close();
	}

}
