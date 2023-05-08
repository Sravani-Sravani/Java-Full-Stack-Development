package com.klu.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@RequestMapping(value="/home")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	@RequestMapping(value="/display")
	public ModelAndView profile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("id",677);
		mv.addObject("name","sravani");
		mv.addObject("department","cse");
		return mv;
	}
	
}