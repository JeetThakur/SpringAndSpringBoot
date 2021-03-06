package com.luv2code.springdemo.mvc;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student") // routing high level router like hello/
public class StudetnController {
	
	// To get the student form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a student 
		Student newStudent = new Student();
		
		// add a student to the model
		theModel.addAttribute("student", newStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("The data that came in: " + theStudent.getFirstName() + " " + theStudent.getSecondName());
		
		return "student-confirmation";
	}

}
