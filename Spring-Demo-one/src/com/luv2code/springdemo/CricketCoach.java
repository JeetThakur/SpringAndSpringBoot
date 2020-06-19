package com.luv2code.springdemo;

public class CricketCoach implements CoachInterface {

	// dependency reference
	private FortuneService fortuneService;
	
	// adding value based injections using setters
	private String emailAddr;
	private String teamName;
	
	public String getEmailAddr() {
		return emailAddr;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setEmailAddr(String emailAddr) {
		//System.out.println("Inside setter for email");
		this.emailAddr = emailAddr;
	}

	public void setTeamName(String teamName) {
		//System.out.println("Inside the setter for teamName");
		this.teamName = teamName;
	}

	// create a no-arg
	public CricketCoach() {
		System.out.println("------Inside the no-arg const-------\n");
	}

	// Setter method 
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		//System.out.println("Inside the setter ... ");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "To be the next Sachin you need to focus and practice, lets hit the middle of the bat";
	}

	@Override
	public String getDailyFortune() {
	
		return "Cricket is crazy, "+fortuneService.getFortune();
	}
	
	public void doMyStuffInitMethod() {
		System.out.println("Inside the init-method");
	}
	
	public void doMyStuffDestroyMethod() {
		System.out.println("Inside the destroy-method");
	}

}
