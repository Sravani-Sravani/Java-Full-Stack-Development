

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerHomeServlet
 */
@WebServlet("/customerhome")
public class CustomerHomeServlet extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session=req.getSession(false);
		String uname=(String)session.getAttribute("uname");
		out.println("<h1 align=center style=\"font-weight:bold;font-size:50px\">Welcome to Enjoy The Show "+uname+" ...!!!</h1>");
		RequestDispatcher rd=req.getRequestDispatcher("customerhome.html");
		rd.include(req,res);
	}
}
