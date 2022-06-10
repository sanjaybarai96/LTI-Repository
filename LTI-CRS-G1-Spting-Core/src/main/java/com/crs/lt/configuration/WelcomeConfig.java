package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lt.crs.client.CrsWelcomeApplication;

@Configuration
@Import({CourseConfig.class,ProfessorConfig.class,StudentConfig.class,UserConfig.class,AdminConfig.class})
public class WelcomeConfig {
	
	@Bean("welcomeMenu")
	public CrsWelcomeApplication welcomeMenu() {
		return new CrsWelcomeApplication();
	}

}
