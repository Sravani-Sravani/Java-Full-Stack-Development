package com.klu.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public ModelAndView home()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
}
