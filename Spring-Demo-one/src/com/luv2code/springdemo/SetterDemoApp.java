package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// This is the main to check the setter injection application 
public class SetterDemoApp {

	public static void main(String[] args) {
	
		// load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve the bean
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		
		// call methods on the bean
		// .... do this later --- lets first check the prints inside the constructor
		System.out.println(theCoach.getDailyFortune() + "\n" +theCoach.getDailyWorkout());
		System.out.println("\nNow checking for value based injections\n");
		
		System.out.println("Fetching the email for the coach:- "+theCoach.getEmailAddr());
		System.out.println("Fetching the team name for which the coach works:- "+theCoach.getTeamName());
		
		// close the bean
		context.close();

	}

}
