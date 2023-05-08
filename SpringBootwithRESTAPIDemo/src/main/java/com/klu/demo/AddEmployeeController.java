package com.klu.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddEmployeeController
{
	@RequestMapping(method=RequestMethod.POST,value="/employee/add")
	@ResponseBody
	public EmployeeResponse addemployee(@RequestBody Employee emp)
	{
		System.out.println("Add Employee Operation");
		EmployeeResponse empresponse=new EmployeeResponse();
		EmployeeOperations.getInstance().add(emp);
		empresponse.setId(emp.getId());
		empresponse.setName(emp.getName());
		empresponse.setGender(emp.getGender());
		empresponse.setDepartment(emp.getDepartment());
		empresponse.setSalary(emp.getSalary());
		empresponse.setLocation(emp.getLocation());
		return empresponse;
	}
}
