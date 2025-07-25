package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	private int cid;
	private String brand;

	@OneToOne
	@JoinColumn(name = "myEngineId")
	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCid() {
		return cid;
	}

	public String getBrand() {
		return brand;
	}

}
