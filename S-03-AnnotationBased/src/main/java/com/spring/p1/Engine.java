package com.spring.p1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	@Value(value = "1000")
	int cc;

	public void engineInfo() {
		System.out.println("CC : " + cc);
	}
}
