package com.spring.di;

public class Student {

	private int sid;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void display() {
		System.out.println("========Student=========");
		System.out.println(sid);
		System.out.println(name);
	}
}
