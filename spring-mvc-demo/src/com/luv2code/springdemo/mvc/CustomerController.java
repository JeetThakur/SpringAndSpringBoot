package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add the initBinder to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theResult ) {
		
		// lets try and see something inside  -- we see that whitespace passed the validation as @NotNull and @Size both get passed because whitespace is an object and size with 1
		//System.out.println(theCustomer.getSecondName());
		
		//  Lets deep dive into string input for integer values
		// lets print the binding results
		System.out.println("Binding result: " + theResult + "\n\n");
		
		
		// if error return the form back
		if(theResult.hasErrors()) {
			return "customer-form";
		}
		
		// else 
		return "customer-confirmation";
	}

}
