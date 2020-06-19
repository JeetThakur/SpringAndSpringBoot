package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	public String coursePrefix;
	
	// get the string from the other side what basically should be present
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	// This is the main part where we produce or write our logic
	// Here we can do anything right from connecting a database -- number crunching -- anything whatever we want
	// this method is called when @Valid is seen in the controller class
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		if (theCode != null) {
		boolean result = theCode.startsWith(coursePrefix);
		return result;
	}
	return false;
	}
}
