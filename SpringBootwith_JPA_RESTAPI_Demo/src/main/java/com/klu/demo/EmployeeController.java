package com.klu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService empservice;
	
	@GetMapping("/employee/getall")
	public List<Employee> getallemprecords()
	{
		return empservice.getallemployeerecords();
	}
	@GetMapping("employee/getbyid/{empid}")
	public Employee getemprecordbyid(@PathVariable("empid") int empid)
	{
		return empservice.getemployeerecordsbyid(empid);
	}
	@PostMapping("/employee/add/")
	public String addemprecord(@RequestBody Employee emp)
	{
		return empservice.insertemployee(emp);
	}
	@PutMapping("/employee/update")
	public String updateemprecord(@RequestBody Employee emp)
	{
		return empservice.updateemprecord(emp);
	}
	@DeleteMapping("employee/delete/{empid}")
	public String deleteemprecord(@PathVariable("empid") int empid)
	{
		return empservice.deleteemprecordbyid(empid);
	}
}
