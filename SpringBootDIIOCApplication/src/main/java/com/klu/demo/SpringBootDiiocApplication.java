package com.klu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDiiocApplication {

	public static void main(String[] args) 
	{
		System.out.println("Spring Boot Dependency Injection & IoC Concept");
		SpringApplication.run(SpringBootDiiocApplication.class, args);
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootDiiocApplication.class, args);
		
		Student s=context.getBean(Student.class);
		
		System.out.println(s);
		
	}

}
