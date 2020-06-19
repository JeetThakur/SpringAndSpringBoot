package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	// Field level injection
	@Value("${email}")	
	private String email;
	
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

	// Field level injection
	@Value("${team}")
	private String team;
	
	public SwimCoach(FortuneService fortune) {
		fortuneService = fortune;
	}
	@Override
	public String getDailyWorkout() {
	
		return "Swim a bit hard today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
