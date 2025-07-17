package com.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee emp1 = app.getBean(Employee.class);
		System.out.println(emp1);

		Employee emp2 = app.getBean(Employee.class);
		System.out.println(emp2);

		Employee emp3 = app.getBean(Employee.class);
		System.out.println(emp3);
	}
}
