package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.lt.service.ProfessorServiceInterface;
import com.crs.lt.serviceimpl.ProfessorService;

public class ProfessorConfig {
	@Bean(name="professorBean")
    public ProfessorServiceInterface professorService() {
        return new ProfessorService();
    }
}
