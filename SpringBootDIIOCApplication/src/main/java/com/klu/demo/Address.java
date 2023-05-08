package com.klu.demo;

import org.springframework.stereotype.Component;

@Component
public class Address 
{
	private String location;
	private int pincode;
	public Address(String location, int pincode) 
	{
		super();
		this.location = location;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [location=" + location + ", pincode=" + pincode + "]";
	}
}
