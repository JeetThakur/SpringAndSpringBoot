package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {
		
		// Load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retreive the beans
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// print methods
		System.out.println(theCoach == alphaCoach);
	
	
		// close the bean
		context.close();
	}
}
