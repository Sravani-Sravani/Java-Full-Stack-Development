package com.klu.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigStudent 
{
	@Bean
	public int id()
	{
		return 55;
	}
	@Bean
	public String name()
	{
		return "Sravani";
	}
	@Bean
	public String gender()
	{
		return "female";
	}
	@Bean
	public double age()
	{
		return 20.3;
	}
	@Bean
	public String department()
	{
		return "CSE";
	}
}
