package com.luv2code.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// Retrieve the beans from the container 
		CoachInterface theCoach =  context.getBean("myCoach", CoachInterface.class);
		CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("\n---------\n");
		System.out.println("The cricket coach: " + theCricketCoach.getDailyWorkout());
		System.out.print(theCricketCoach.getTeamName());
		
		context.close();
	}

}
