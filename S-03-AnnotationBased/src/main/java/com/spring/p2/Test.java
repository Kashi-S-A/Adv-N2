package com.spring.p2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

		Person person = app.getBean(Person.class);

		person.use();
	}
}
