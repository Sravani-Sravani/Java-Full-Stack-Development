import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cancelticket")
public class CancelTicketServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(false);
	    String  customername=(String)session.getAttribute("uname");
	    String bookingid=req.getParameter("bookingid");
	    String status="CANCELLED";
	    try
		{
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update ticketbooking set status=? where bookingid=?");	
			pstmt.setString(1,status);
			pstmt.setString(2,bookingid);
			int i= pstmt.executeUpdate();
			if(i>0)
			{
				out.println("<script>\r\n" + 
						"			alert(\"Ticket Cancelled Successfully\");\r\n" + 
						"			window.location=\"viewcustomertickets\";\r\n" + 
						"			</script>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
