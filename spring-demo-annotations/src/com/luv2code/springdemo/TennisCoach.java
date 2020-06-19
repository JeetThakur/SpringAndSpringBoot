package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// This annotation @Component(<bean-id-StringValue>) will create a bean in the back by Spring
@Component
@Scope
public class TennisCoach implements Coach {

	// This will work as Java Reflection --- autowired directly without setter getter ..
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService myFortune;
		
	
	//	This is the excercise for the @Value 
	//	@Value("${foo.email}")
	//	private String email;
	
	
	
	// define my init
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Inside do my startup stuff : TennisCoach");
	}
	
	// define my destroy
	@PreDestroy
	public void doMyCleanup() {
		System.out.println("Inside cleanup: TennisCoach");
	}
	
	
	// This is the autowired annotation using the spring framework

	//	@Autowired
	//	public TennisCoach(FortuneService theFortuneService) {
	//		myFortune = theFortuneService;
	//	}
	
	
	// No-arg for setter injections
	public TennisCoach() {
		System.out.println("Default running here ... \n");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice the backhand and the top sping daily for the best results";
	}
	
	// This is for the same @Value
	//	public String getEmail() {
	//		return email;
	//	}

	@Override
	public String getDailyFortune() {
		return myFortune.getFortune();
	}
	
// To check the reflection java approach by using autowired at the field init
//	@Autowired
//	public void doFortuneService(FortuneService theFortuneService) {
//		System.out.println("inside the setter method for the class");
//		myFortune = theFortuneService;
//	}

}
