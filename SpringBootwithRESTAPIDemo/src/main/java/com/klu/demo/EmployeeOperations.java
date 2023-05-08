package com.klu.demo;
import java.util.ArrayList;
import java.util.List;
public class EmployeeOperations 
{
	 private List<Employee> employeerecords;
	  public static EmployeeOperations empid=null;
	  
	  private EmployeeOperations()
	  {
	    employeerecords=new ArrayList<Employee>();
	  }
	  
	  // getInstance() method will return the current instance in the class
	  
	  public static EmployeeOperations getInstance()
	  {
	    if(empid==null)
	    {
	      empid=new EmployeeOperations();
	      return empid;
	    }
	    else
	      return empid;
	  }
	  
	  public void add(Employee emp) // add employee
	  {
	    employeerecords.add(emp);
	  }
	  
	  public String UpdateEmployee(Employee emp) // update employee
	  {
	    for(int i=0;i<employeerecords.size();i++)
	    {
	      Employee emp1=employeerecords.get(i);
	      if(emp.getId()==emp1.getId())
	      {
	        employeerecords.set(i,emp); // update the employee record
	        return "Update-success";
	      }
	    }
	    return "Update-fail";
	  }
	  
	  public String DeleteEmployee(int empid) // delete employee
	  {
	    for(int i=0;i<employeerecords.size();i++)
	    {
	      Employee emp=employeerecords.get(i);
	      if(empid==emp.getId())
	      {
	        employeerecords.remove(i); //It will delete the employee record
	        return "Delete-success";
	      }
	    }
	    return "Delete-fail";
	  }
	  
	  public List<Employee> getEmployeeRecords() // view all employees
	  {
	    return employeerecords;
	  }	
}
