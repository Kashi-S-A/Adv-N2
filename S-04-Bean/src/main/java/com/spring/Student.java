package com.spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value(value = "Dinga")
	String name;

	@Autowired
	List<String> subjects;

	@Autowired
	Address address;

	@Autowired
	Scanner scanner;

	public void display() {
		System.out.println("Student info");
		System.out.println("Name : " + name);
		System.out.println("subjects : " + subjects);
		System.out.println(address);
		System.out.println("say something");
		String s = scanner.nextLine();
		System.out.println("You said : " + s);
	}
}
