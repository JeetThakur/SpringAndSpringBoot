package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class JumpCoach implements Coach {

	// Define the fortuneService
	private FortuneService myFortuneService;
	@Value("${team}")
	private String team;

	@Value("${email}")
	private String email;
	// public Constructor
	public JumpCoach(FortuneService laughingFortune) {
		myFortuneService = laughingFortune;
	}
	
	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}	
	
	@Override
	public String getDailyWorkout() {
		return "Jump like you have never jumped before";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
