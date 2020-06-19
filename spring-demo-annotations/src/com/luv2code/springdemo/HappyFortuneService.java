package com.luv2code.springdemo;
import java.util.*;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	private String fortune;
	
	@PostConstruct
	public void gettingDone() {
		Scanner sc =  new Scanner(System.in) ;
		System.out.println("Is this working ?");
		fortune = sc.nextLine(); 
		
	}
	
	@Override
	public String getFortune() {	
		return fortune;
	}

}
