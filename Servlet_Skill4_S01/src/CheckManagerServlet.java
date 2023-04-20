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
@WebServlet("/checkmanager")
public class CheckManagerServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+","+pwd);
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from manager where username=? and password=?");
			pstmt.setString(1,  uname);
			pstmt.setString(2,  pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				HttpSession session=req.getSession();
				session.setAttribute("uname",uname);
				RequestDispatcher rd=req.getRequestDispatcher("managerhome.html");
						rd.forward(req,res);
			}
			else
			{
				res.sendRedirect("managerlogin.html");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
}
