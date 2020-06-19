package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // gets picked up at Component scanning inheritted
public class HomeController {

	
	@RequestMapping("/")
	// This is cool as this will be able to handle all types of http requesst get/post and all other requests 
	public String ShowPage() {
		
		// This main-menu will be found from the config file using the prefix and suffix from the file 
		return "main-menu";
		
	}
	
}
