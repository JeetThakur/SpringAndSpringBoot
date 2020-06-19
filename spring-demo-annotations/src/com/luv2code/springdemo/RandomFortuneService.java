package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	Random rand = new Random();
	
	// filename
	private String fileName = "src\\fortune.txt";
	
	
	// arraylist to hold the file contents
	private ArrayList<String> fortunes = new ArrayList(); 
	
	public RandomFortuneService() {
		System.out.println("This is the default constructor");
	}
	
	@PostConstruct
	public void getMeMyFortune() {
		System.out.println("Fetching the file ..... fortune.txt");
		try( BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				fortunes.add(tempLine);
			}
		}
		catch(Exception e) {
					e.printStackTrace();
				}
	}

	
	@Override
	public String getFortune() {
	
	return fortunes.get(rand.nextInt(fortunes.size()));
	}
}
