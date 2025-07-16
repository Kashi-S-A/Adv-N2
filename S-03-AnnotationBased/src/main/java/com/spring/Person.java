package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

//	@Value(value = "101")
	int pid;

//	@Value(value = "Dinga")
	String name;

//	@Value(value = "102")
	public void setPid(int pid) {
		this.pid = pid;
	}

//	@Value(value = "Dingi")
	public void setName(String name) {
		this.name = name;
	}

	public Person(@Value(value = "103") int pid, @Value(value = "Manga") String name) {
		this.pid = pid;
		this.name = name;
	}

	public void display() {
		System.out.println("Pid : " + pid);
		System.out.println("Name : " + name);
	}
}
