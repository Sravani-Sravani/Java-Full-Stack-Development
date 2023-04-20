package com.klef;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String location=req.getParameter("location");
		
		Employee emp=new Employee();
		emp.setName(name);
		emp.setGender(gender);
		emp.setUsername(username);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setLocation(location);
		int i=DBOperations.registration(emp);
		if(i>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("RegistrationSuccess.jsp");
			rd.forward(req,res);
		}
				
	}
}
