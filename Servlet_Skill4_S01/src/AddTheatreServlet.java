

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtheatre")
public class AddTheatreServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String tname=req.getParameter("name");
	String year=req.getParameter("establishedyear");
	String address=req.getParameter("address");
	String pincode=req.getParameter("pincode");
	String capacity=req.getParameter("capacity");
	String tprice=req.getParameter("ticketprice");
	try 
    {
    	Connection con=DBConnection.getConnection();
    	PreparedStatement pstmt=con.prepareStatement("insert into theatre(name,establishedyear,address,pincode,capacity,ticketprice) values(?,?,?,?,?,?)");
    	pstmt.setString(1,tname);
    	pstmt.setString(2,year);
    	pstmt.setString(3,address);
    	pstmt.setString(4,pincode);
    	pstmt.setString(5,capacity);
    	pstmt.setString(6,tprice);
    	int i=pstmt.executeUpdate();
    	if(i>0)
    	{
    		res.sendRedirect("superadminhome.html");
    	}
    	else
    	{
    		res.sendRedirect("addtheatre.html");
    	}
    	
    }
    catch(Exception e)
    {
    	out.println("Exception:"+e);
    }
	
	}
}
