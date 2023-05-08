package com.klu.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ClientController
{
	@RequestMapping(value="/demo")
	public String display()
	{
		return "index";
	}
	@RequestMapping(value="/name")
	public String display1()
	{
		return "name";
	}
}
