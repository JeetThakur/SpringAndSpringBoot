package com.luv2code.springdemo;

// A player of the demo project type
// Learning Inversion Of Control (IoC -- Spring framework )
public class BaseballCoach implements CoachInterface {
	
	//define a private field for the dependency 
	private FortuneService fortuneService;

	// define a constructor for the dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	// This will be a return to another class which requests a daily workout
	// This function is responsible to provide with that requested daily workout 
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortune service to get a fortune
		return fortuneService.getFortune();
	}
	
}
