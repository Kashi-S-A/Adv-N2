package com.spring.XmlAndAnn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//setter injection
@Component
public class Employee {

	private String name;
	private int eid;

	@Value(value = "Penga")
	public void setName(String name) {
		this.name = name;
	}

	@Value(value = "222")
	public void setEid(int eid) {
		this.eid = eid;
	}

	public void work() {
		System.out.println(name + " with " + eid + " is Working on project");
	}
}
