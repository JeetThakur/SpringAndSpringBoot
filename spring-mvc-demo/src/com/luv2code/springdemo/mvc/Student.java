package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

// This is the student class to hold our student objects
public class Student {

	private String firstName;
	private String secondName;
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystems;
	
	// This is to make sure we do not hardcode the dropdown options in the html but come from the java source code / file or prop file
	private LinkedHashMap <String, String> countryOptions;
	public Student() {
		countryOptions = new LinkedHashMap();
		// add values
		//countryOptions.put("BRZ", "Brazil");
		countryOptions.put("FRA", "France");
		countryOptions.put("IND", "India");
		countryOptions.put("USA", "United States of America");
	}
	
	
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	public void setOperatingSystems(String os[]) {
		operatingSystems = os;
	}
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}
	public void setFavouriteLanguage(String favLang) {
		favouriteLanguage = favLang;
	}
	
	public LinkedHashMap<String,String> getCountryOptions() {
		return countryOptions;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
}
