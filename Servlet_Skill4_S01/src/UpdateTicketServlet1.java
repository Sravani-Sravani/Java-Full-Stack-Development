import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/updateticket1")
public class UpdateTicketServlet1 extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(false);
		String  customername=(String)session.getAttribute("uname");
	    String bookingid=(String)session.getAttribute("bookingid");
	    int ticketscount=Integer.parseInt(req.getParameter("ticketscount"));
	    String status="UPDATED";
	    double ticketprice=0.0;
	    int capacity=0;
	    int theatreid=0;
	    try
	    {
	    	Connection con=DBConnection.getConnection();
		      PreparedStatement pstmt=con.prepareStatement("select theatreid from ticketbooking where bookingid=?");
		      pstmt.setString(1,bookingid);
		      ResultSet rs=pstmt.executeQuery();
		      if(rs.next())
		      {
		        theatreid=rs.getInt(1);    
		      }
	    }
	  
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	    
	    try
	    {
	    	Connection con=DBConnection.getConnection();
		      PreparedStatement pstmt=con.prepareStatement("select ticketprice,capacity from theatre where theatreid=?");
		      pstmt.setInt(1,theatreid);
		      ResultSet rs=pstmt.executeQuery();
		      if(rs.next())
		      {
		        ticketprice=rs.getDouble("ticketprice");
		        capacity=rs.getInt("capacity");
		        
		      }

	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	    System.out.println(ticketprice);
	    System.out.println(ticketscount);
	    int ticketsbooked=0;
	    int movieid = 0;
	    String showslot = null,showdate = null;
	    try
	    {
	    	Connection con = DBConnection.getConnection();
	    	PreparedStatement pstmt2=con.prepareStatement("select movieid,showdate,showslot from ticketbooking where bookingid=?");
	    	pstmt2.setString(1,bookingid);
	        ResultSet rs=pstmt2.executeQuery();
	        rs.next();
	    	movieid=rs.getInt("movieid");
	    	showdate=rs.getString("showdate");
	    	showslot=rs.getString("showslot");
	    	
	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	    double totalprice=ticketprice*ticketscount;
	    try
	    {
	    	System.out.println(movieid);
	    	Connection con = DBConnection.getConnection();
	    	PreparedStatement pstmt2=con.prepareStatement("select sum(ticketscount) from ticketbooking where theatreid=? and movieid=? and showslot=? and status!=? and showdate=?");
		      pstmt2.setInt(1, theatreid);
		      pstmt2.setInt(2, movieid);
		      pstmt2.setString(3, showslot);
		      pstmt2.setString(4, "CANCELLED");
		      pstmt2.setString(5, showdate);
		      ResultSet rs2=pstmt2.executeQuery();
		      if(rs2.next())
		      {
		    	  ticketsbooked=rs2.getInt(1);
		      }
	    	 if(ticketsbooked+ticketscount<capacity)
	    	 {
			PreparedStatement pstmt = con.prepareStatement("update ticketbooking set status=? , ticketscount=? ,price=? where bookingid=?");	
			pstmt.setString(1,status);
			pstmt.setInt(2,ticketscount);
			pstmt.setDouble(3,totalprice);
			pstmt.setString(4,bookingid);
			
			int i= pstmt.executeUpdate(); 
			if(i>0)
			{
				out.println("<script>\r\n" + 
						"			alert(\"Ticket Updated Successfully\");\r\n" + 
						"			window.location=\"viewcustomertickets\";\r\n" + 
						"			</script>");
			}	
	    }
	    	 else
		      {
		    	  out.println("<h1>No tickets are available</h1>");
		      }
	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	}
}
