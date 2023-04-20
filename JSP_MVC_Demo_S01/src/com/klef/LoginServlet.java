package com.klef;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	  {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    
	    Employee emp = new Employee();
	    emp.setUsername(username);
	    emp.setPassword(password);
	    
	    boolean flag = DBOperations.Login(emp);
	    
	    if(flag)
	    {
	      req.setAttribute("empbean", emp);
	      RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess.jsp");
	      rd.forward(req, res);
	    }
	    else
	    {
	      RequestDispatcher rd = req.getRequestDispatcher("LoginFailed.jsp");
	      rd.forward(req, res);
	    }
	  }
}
