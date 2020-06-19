package com.luv2code.springdemo;

public class LaughingFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is good for jumping";
	}

}
