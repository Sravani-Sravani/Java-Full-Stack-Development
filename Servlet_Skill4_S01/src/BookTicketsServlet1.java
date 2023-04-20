import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/bookticket1")
public class BookTicketsServlet1 extends HttpServlet 
{
	  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	  {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    int value=(int)((Math.random()*999999))+1;
	    String bookingid="TKT"+Integer.toString(value);
	    
	    try
	    {
	      HttpSession session=req.getSession(false);
	      String  customername=(String)session.getAttribute("uname");
	      int movieid=Integer.parseInt(req.getParameter("movieid"));
	      int theatreid=Integer.parseInt(req.getParameter("theatreid"));
	      String showdate=req.getParameter("showdate");
	      String showslot=req.getParameter("showslot");
	      int ticketscount=Integer.parseInt(req.getParameter("ticketscount"));
	      int capacity=0;
	      double ticketprice=0.0;
	      String status="BOOKED";
	      int ticketsbooked=0;
	      Connection con=DBConnection.getConnection();
	      PreparedStatement pstmt=con.prepareStatement("select ticketprice,capacity from theatre where theatreid=?");
	      pstmt.setInt(1,theatreid);
	      ResultSet rs=pstmt.executeQuery();
	      if(rs.next())
	      {
	        ticketprice=rs.getDouble("ticketprice");
	        capacity=rs.getInt("capacity");
	        
	      }
	      double totalprice=ticketprice*ticketscount;
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
	    	  System.out.println(ticketsbooked);
	      }
	      if(ticketsbooked+ticketscount<capacity)
	      {
	      PreparedStatement pstmt3=con.prepareStatement("insert into ticketbooking(bookingid,customeruname,movieid,theatreid,showdate,showslot,ticketscount,price,status) values(?,?,?,?,?,?,?,?,?)");
	      pstmt3.setString(1, bookingid);
	      pstmt3.setString(2, customername);
	      pstmt3.setInt(3, movieid);
	      pstmt3.setInt(4,theatreid);
	      pstmt3.setString(5, showdate);
	      pstmt3.setString(6, showslot);
	      pstmt3.setInt(7, ticketscount);
	      pstmt3.setDouble(8, totalprice);
	      pstmt3.setString(9, status);
	      int i=pstmt3.executeUpdate();
	      
	      if(i>0)
	      {
	        out.println("Success");
	        RequestDispatcher rd=req.getRequestDispatcher("customerhome");
	        rd.include(req,res);
	      }
	      
	      }
	      else
	      {
	    	  out.println("<h1>No tickets are available</h1>");
	      }
	      
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	    }
}
