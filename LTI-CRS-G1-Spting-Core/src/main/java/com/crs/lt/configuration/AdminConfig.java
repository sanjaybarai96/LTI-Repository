package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.lt.service.AdminServiceInterface;
import com.crs.lt.serviceimpl.AdminService;


public class AdminConfig {
	@Bean(name="adminBean")
    public AdminServiceInterface adminService() {
        return new AdminService();
    }
}
