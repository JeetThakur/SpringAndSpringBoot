package com.luv2code.springdemo;

import java.util.Random;

public class RandomHappyFortuneService implements FortuneService {

	private String[] fortunes = {"Hello", "Hi", "I am your fortune today"};
	
	@Override
	public String getFortune() {
		Random r = new Random();
		return fortunes[ r.nextInt((fortunes.length - 1) + 1)];
	}

}
