package com.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config2.xml");

		Person person = (Person) app.getBean("myPerson");
		person.talk();

		Student student = (Student) app.getBean("myStudent");
		student.study();

		app.close();
	}
}
