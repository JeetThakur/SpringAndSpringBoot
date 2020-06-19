package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;



// Our Customer class
public class Customer {

	private String firstName;
	
	// required field
	@NotNull(message="is required")
	@Size(min=1, message= "is required")
	private String secondName;
	
	
	// Min and max number range
	@Min(value=0 , message="cannot have a negative value")
	@Max(value=5 , message="cannot get free passes more than 5")
	@NotNull(message="is required")
	private Integer freePasses;
	
	// Regex
	@Pattern(regexp="^[0-9]{5}(?:-[0-9]{4})?$" , message="The postal code must be a valid USA postal code")
	private String postalCode;
	
	
	// Custom Annotation -- created into the package .validations
	@CourseCode(value="MojoJogo", message="must start with required course code")
	private String courseCode;
	
	
	// Getter and setter 
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	
}
