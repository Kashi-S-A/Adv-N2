package com.spring;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student = app.getBean(Student.class);
		student.display();

//		Scanner sc = app.getBean(Scanner.class);
		Scanner sc = (Scanner) app.getBean("scannerBean");
		System.out.println("enter int");
		int a = sc.nextInt();
		System.out.println("Entered : " + a);

	}
}
