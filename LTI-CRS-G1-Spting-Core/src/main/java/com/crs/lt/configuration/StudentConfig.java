package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.lt.service.StuentServiceInterface;
import com.crs.lt.serviceimpl.StudentService;


public class StudentConfig {
	@Bean(name="studentBean")
    public StuentServiceInterface studentService() {
        return new StudentService();
    }
}
