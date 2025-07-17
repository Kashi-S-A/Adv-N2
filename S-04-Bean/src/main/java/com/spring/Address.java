package com.spring;

public class Address {

	String street;
	String state;
	String city;
	Integer zipcode;

	@Override
	public String toString() {
		return "Address [street=" + street + ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	public Address(String street, String state, String city, Integer zipcode) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

}