package com.klu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student 
{
	private int id;
	private String name;
	private String gender;
	private double age;
	private String department;
	@Autowired
	private Address address;
	public Student(int id, String name, String gender, double age, String department, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.department = department;
		this.address = address;
	}
	
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", departmant="
				+ department + ", address=" + address.toString() + "]";
	}
	
	
}
