package com.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring")
public class AppConfig {

	@Bean
	public List<String> getSubjects() {
		return Arrays.asList("HTML", "JAVA", "Spring Boot");
	}

	@Bean(value = "scannerBean")
	public Scanner getScanner() {
		return new Scanner(System.in);
	}

	@Bean
	public Address getAddress() {
		return new Address("XYZ street", "Maharashtra", "Mumbai", 600100);
	}
}
