package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// Read the Java Config file now -- NO XML REQUIRED
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// read the bean -- getting the object created by spring
		//Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// For the activity to use @Value
		TennisCoach theTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		
		
		// get methods
		System.out.println("The tennis coach via the @Component annotation:- " + theTennisCoach.getDailyWorkout());
		
		// get the daily fortune method
		System.out.println(theTennisCoach.getDailyFortune());
		//System.out.println(theTennisCoach.getEmail());
		
		// clean the bean
		context.close();
	}

}
