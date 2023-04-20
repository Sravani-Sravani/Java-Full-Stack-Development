

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
@WebServlet("/addtmanager")
public class AddTManagerServlet extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	RequestDispatcher rd=req.getRequestDispatcher("addtmanager.html");
	rd.include(req,res);
	
	try
	{
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from theatre");	
		ResultSet rs = pstmt.executeQuery();
		out.println("<br><span class=\"input-item\">\r\n" + 
				"           <i class=\"fa fa-film\"></i>\r\n" + 
				"         </span>\r\n" + 
				"        <select id=\"standard-select\" name=\"theatreid\" required>\r\n" + 
				"          <option value=\"choose\" align=center style=\"text-align: center;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select</option>\r\n" + 
				"");
		while(rs.next())
		{
			out.println( 
					"    <option value=\""+rs.getInt("theatreid")+"\" align=center style=\"text-align: center;\">"+rs.getString("name")+"</option>\r\n" );
		}
		out.println("</select>\r\n" + 
				"      <br>  ");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	out.println("<button class=\"log-in\"> Add Theatre </button>\r\n" + 
			"   </div>\r\n" + 
			"  </div>\r\n" + 
			"</form>\r\n" + 
			"</div>");
	
	}
}
