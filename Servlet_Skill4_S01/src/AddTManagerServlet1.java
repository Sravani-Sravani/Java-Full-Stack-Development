

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtmanager1")
public class AddTManagerServlet1 extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String name=req.getParameter("name");
	String gender=req.getParameter("gender");
	String uname=req.getParameter("uname");
	String email=req.getParameter("email");
	String pwd=req.getParameter("pwd");
	String mobile=req.getParameter("mobile");
	String location=req.getParameter("location");
	String theatreid=req.getParameter("theatreid");
	try 
    {
    	Connection con=DBConnection.getConnection();
    	PreparedStatement pstmt=con.prepareStatement("insert into manager(name,gender,username,email,password,mobileno,location,theatreid) values(?,?,?,?,?,?,?,?)");
    	pstmt.setString(1,name);
    	pstmt.setString(2,gender);
    	pstmt.setString(3,uname);
    	pstmt.setString(4,email);
    	pstmt.setString(5,pwd);
    	pstmt.setString(6,mobile);
    	pstmt.setString(7,location);
    	pstmt.setString(8,theatreid);
    	int i=pstmt.executeUpdate();
    	if(i>0)
    	{
    		res.sendRedirect("superadminhome.html");
    	}
    	else
    	{
    		res.sendRedirect("addtmanager");
    	}
    	
    }
    catch(Exception e)
    {
    	out.println("Exception:"+e);
    }
		
}
}
