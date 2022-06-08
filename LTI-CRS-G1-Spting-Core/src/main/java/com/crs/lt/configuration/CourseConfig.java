package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.lt.service.CourseServiceInterface;
import com.crs.lt.serviceimpl.CourseService;


public class CourseConfig {

	@Bean(name="courseBean")
    public CourseServiceInterface courseService() {
        return new CourseService();
    }
}
