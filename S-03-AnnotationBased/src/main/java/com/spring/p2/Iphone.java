package com.spring.p2;

import org.springframework.stereotype.Component;

@Component
public class Iphone implements Mobile {

	@Override
	public void ringing() {
		System.out.println("Iphone is ringing");
	}

}
