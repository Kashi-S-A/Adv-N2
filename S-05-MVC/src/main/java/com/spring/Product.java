package com.spring;

public class Product {

	private int pid;
	private String name;
	private double price;

	public Product(int pid, String name, double price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
