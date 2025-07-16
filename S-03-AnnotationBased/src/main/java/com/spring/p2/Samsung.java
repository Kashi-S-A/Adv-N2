package com.spring.p2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Samsung implements Mobile {

	@Override
	public void ringing() {
		System.out.println("Samsung is ringing");
	}

}
