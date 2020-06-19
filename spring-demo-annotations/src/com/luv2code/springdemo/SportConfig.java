package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Config file -- using the Annotations -- the place where we define our beans
@Configuration
//// This is now the place where we scan the package
//@ComponentScan("com.luv2code.springdemo")

// Now add the property file here
@PropertySource("classpath:SwimProp")
public class SportConfig {
	
	// define bean for sad fortuneService
	@Bean 
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// define SwimCoach and inject sad fortuneservice
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
