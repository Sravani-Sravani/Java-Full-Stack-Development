package com.klu.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// localhost:2020/employee/all

@Controller
public class ViewEmployeeController
{
@RequestMapping(method=RequestMethod.GET,value="/employee/all")
@ResponseBody
public List<Employee> getAllEmployees()
{
return EmployeeOperations.getInstance().getEmployeeRecords();
}
}