package com.klu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository emprepository;
	
	public List<Employee> getallemployeerecords()
	{
		return (List<Employee>) emprepository.findAll();
	}
	public Employee getemployeerecordsbyid(int empid)
	{
		return emprepository.findById(empid).get();
	}
	public String insertemployee(Employee emp)
	{
		emprepository.save(emp);
		return "Employee Record added Successfully";
	}
	public String updateemprecord(Employee emp)
	{
		emprepository.save(emp);
		return "Employee Record Updated Successfully";
	}
	public String deleteemprecordbyid(int empid)
	{
		emprepository.deleteById(empid);
		return "Employee Record Deleted Successfully";
	}
}
