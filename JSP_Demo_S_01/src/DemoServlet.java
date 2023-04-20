import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.Student;
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
	int id=Integer.parseInt(req.getParameter("id"));;
	String name=req.getParameter("name");
	String gender=req.getParameter("gender");
	double age=Double.parseDouble(req.getParameter("age"));
	
	Student StudentBean=new Student();
	StudentBean.setId(id);
	StudentBean.setName(name);
	StudentBean.setGender(gender);
	StudentBean.setAge(age);
	req.setAttribute("StudentBean",StudentBean);
    
    RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
    rd.forward(req,res);	
}
}
