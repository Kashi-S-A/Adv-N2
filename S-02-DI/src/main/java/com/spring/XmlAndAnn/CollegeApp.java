package com.spring.XmlAndAnn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//constructor injection
@Component
public class CollegeApp {

	String name;
	String address;

	public CollegeApp(@Value(value = "KJ") String name, @Value(value = "Thane") String address) {
		this.name = name;
		this.address = address;
	}

	public void admission() {
		System.out.println("admissions started in college : " + name + " located in : " + address);
	}
}
