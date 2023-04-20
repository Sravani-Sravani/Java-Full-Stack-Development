import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addmovie1")
public class AddMovieServlet1 extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String name=req.getParameter("name");
	String language=req.getParameter("language");
	String genre=req.getParameter("genre");
	String director=req.getParameter("director");
	String producer=req.getParameter("producer");
	String cast=req.getParameter("cast");
	String rdate=req.getParameter("rdate");
	String crating=req.getParameter("cbrating");
	try 
    {
    	Connection con=DBConnection.getConnection();
    	PreparedStatement pstmt=con.prepareStatement("insert into movie(name,language,genre,director,producer,cast,releasedate,censorboardrating) values(?,?,?,?,?,?,?,?)");
    	pstmt.setString(1,name);
    	pstmt.setString(2,language);
    	pstmt.setString(3,genre);
    	pstmt.setString(4,director);
    	pstmt.setString(5,producer);
    	pstmt.setString(6,cast);
    	pstmt.setString(7,rdate);
    	pstmt.setString(8,crating);
    	int i=pstmt.executeUpdate();
    	if(i>0)
    	{
    		res.sendRedirect("managerhome.html");
    	}
    	else
    	{
    		res.sendRedirect("maddmovie.html");
    	}
    	
    }
    catch(Exception e)
    {
    	out.println("Exception:"+e);
    }
	
	}
}
