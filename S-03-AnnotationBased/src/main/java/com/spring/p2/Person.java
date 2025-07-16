package com.spring.p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value(value = "Penga")
	private String name;

//	@Autowired
//	@Qualifier(value = "iphone")
	private Mobile mobile;

//	@Autowired
//	@Qualifier(value = "iphone")
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Autowired
	public Person(@Qualifier(value = "iphone") Mobile mobile) {
		this.mobile = mobile;
	}

	public void use() {
		System.out.println(name + " is using mobile ");
		mobile.ringing();
	}
}
