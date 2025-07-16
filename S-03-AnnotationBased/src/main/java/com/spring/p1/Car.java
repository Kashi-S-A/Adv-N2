package com.spring.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value(value = "Audi")
	String brand;

	@Value(value = "800000")
	double price;

//	@Autowired       //variable/ field injection
	Engine engine;

//	@Autowired // setter injection
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

//	@Autowired	//constructor injection
	public Car(@Autowired Engine engine) {
		this.engine = engine;
	}

	public void carInfo() {
		System.out.println("brand : " + brand);
		System.out.println("price : " + price);
		System.out.print("engine cc : ");
		engine.engineInfo();
	}
}
