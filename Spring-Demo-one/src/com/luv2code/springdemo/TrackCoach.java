package com.luv2code.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements CoachInterface, DisposableBean {

	
	//define a private field for the dependency 
	private FortuneService fortuneService;

	public TrackCoach() {
		
	}
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// use the service 
		return "Just Do it ... " + fortuneService.getFortune();
	}
	
	//  add init method -- hooks
	public void doMyStartupStuff() {
		System.out.println("Track Coach: inside method init-method");
		
	}
	
	/// add destroy method -- hooks
	public void doMyCleanupStuffYoYo() {
		System.out.println("Track Coach: Inside mehtod destroy-method ... yoyo is to show that name doesnt matter");
	}
	
	@Override
	public void destroy() throws Exception {
		doMyCleanupStuffYoYo();
	}
}
