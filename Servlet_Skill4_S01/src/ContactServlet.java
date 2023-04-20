import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contactservlet")
public class ContactServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
	    PrintWriter out=res.getWriter();
	    String email=req.getParameter("email");
	    String mes=req.getParameter("mes");
	    try 
	    {
	    	Connection con=DBConnection.getConnection();
	    	PreparedStatement pstmt=con.prepareStatement("insert into contact(email,mes) values(?,?)");
	    	pstmt.setString(1,email);
	    	pstmt.setString(2,mes);
	    	int i=pstmt.executeUpdate();
	    	if(i>0)
	    	{
	    		res.sendRedirect("index.html");
	    	}
	    	
	    }
	    catch(Exception e)
	    {
	    	out.println("Exception:"+e);
	    }
	}

}
