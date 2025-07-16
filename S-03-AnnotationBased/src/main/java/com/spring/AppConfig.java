package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.spring", "com.spring.p1", "com.spring.p2" })
public class AppConfig {

}
