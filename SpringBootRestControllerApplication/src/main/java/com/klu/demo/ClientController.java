package com.klu.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController 
{
	@GetMapping(value="/")
	public String display1()
	{
	return "Welcome to Spring Boot Rest Controller";
	}
	@GetMapping(value="/klef")
	public String display2()
	{
	return "Welcome to KLEF";
	}
	@GetMapping(value="/demo")
	public String display3()
	{
	return "Welcome to KLU";
	}
	@GetMapping(value="/student")
	public Student display4()
	{
		Student s=new Student();
		s.setId("677");
		s.setName("Sravani");
		s.setDepartment("CSE");
		s.setAge(20.03);
		return s;
	}
	@GetMapping(value="/studentid")
	public String display5()
	{
		Student s=new Student();
		s.setId("677");
		s.setName("Sravani");
		s.setDepartment("CSE");
		s.setAge(20.03);
		return s.getId();
	}
	@GetMapping("test")
	public String display6()
	{
		return "Sample Test";
	}
	@GetMapping(value="demo1")
	  public String display6(@RequestParam String name)
	  {
	    String msg="Welcome "+name;
	    
	    return msg;
	  }
	@GetMapping(value="demo2/{name}")
	  public String display7(@PathVariable String name)
	  {
	    String msg="Welcome "+name;
	    
	    return msg;
	  }
}