package com.crs.lt.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.lt.service.UserServiceInterface;
import com.crs.lt.serviceimpl.UserService;


public class UserConfig {
	@Bean(name="userBean")
    public UserServiceInterface userService() {
        return new UserService();
    }
}
