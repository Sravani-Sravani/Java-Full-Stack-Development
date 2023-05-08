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
	@RequestMapping(value="/details")
	public ModelAndView profile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("details");
		mv.addObject("id",677);
		mv.addObject("name","SRAVANI");
		mv.addObject("department","CSE");
		return mv;
	}
	@RequestMapping(value="/mvc")
	public ModelAndView mvc()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mvc");
		
		return mv;
	}
}