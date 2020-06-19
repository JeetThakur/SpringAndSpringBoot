package com.luv2code.springdemo;

// This is the main app for the application
public class MyApp {

	public static void main(String[] args) {
		// Create the object 
				
		/*		
		 *  Using the interface object helps us to make sure
		 *  we can use any implementation of the interface or a strict 
		 *  Implementation of a specific interface object 
		*/
		
		/*
		 *  This little line here down helped us only for a specefic coach type baseball
		 *  
		 *  CoachInterface theCoach = new BaseballCoach();
		 *  
		 *   what if this app needs to run on any type of coach ???
		*/

		// we will use something like this:-
		CoachInterface theCoach = new TrackCoach();
		
			
		// use the object
		// This will now also help us check the box out for inter app connectivity
		
		System.out.println(theCoach.getDailyWorkout());
		
	}

}
