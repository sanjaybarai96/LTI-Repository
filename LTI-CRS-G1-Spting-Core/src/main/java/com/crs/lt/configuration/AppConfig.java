package com.crs.lt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(WelcomeConfig.class)
public class AppConfig {

}
