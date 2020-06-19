package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:SwimProp")
public class MySportConfig {

	@Bean
	public FortuneService laughingFortuneService() {
		return new LaughingFortuneService();
	}
	
	@Bean
	public Coach jumpCoach() {
		return new JumpCoach(laughingFortuneService());
	}
}
