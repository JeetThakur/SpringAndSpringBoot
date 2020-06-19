package com.luv2code.springdemo.mvc;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello") // The higher level mapper the main route for the router
public class HelloWorldController {

	// Need method to show initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		// Spring mvc will go behind the scene and add the prefix and suffix of the package in the view and make sure it works
		return "helloworld-form";
	}
	
	// Need method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}

	// new method to read form data
	// add data
	
	// pushing new versions for each different processForms
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		// covert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
	
	// Annotations example
	@RequestMapping("/processFormVersionTwoAnnotations")
	public String letsShoutAnnotations(@RequestParam("studentName") String theName , Model model) {

		// Read the request param -- done already using the annotation uptop ... different from regular version two

		// covert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "This is using Annotations! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
