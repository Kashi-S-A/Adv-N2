package com.spring.di;

public class Person {

	int pid;
	String name;
	String address;

	public Person(int pid, String name, String address) {
		this.pid = pid;
		this.name = name;
		this.address = address;
	}

	public void display() {
		System.out.println("pid : " + pid);
		System.out.println("Name : " + name);
		System.out.println("Address : " + address);
	}

}
