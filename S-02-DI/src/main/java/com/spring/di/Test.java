package com.spring.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Student student = (Student) app.getBean("stuBean");

		student.display();

		System.out.println("================================");

		Person person = (Person) app.getBean("personBean");

		person.display();
	}
}
