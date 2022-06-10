package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.lt.repository")
@EntityScan("com.lt.entity")	
@ComponentScan("com.lt.*")
@EnableWebMvc
public class LtiCrsSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiCrsSpringDataJpaApplication.class, args);
	}

}
