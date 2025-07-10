package com.ty;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {

	// used to represent the composite key
	@EmbeddedId
	private EmployeeId eid;

	private String name;
	private double salary;

	public void setEid(EmployeeId eid) {
		this.eid = eid;
	}

	public EmployeeId getEid() {
		return eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
