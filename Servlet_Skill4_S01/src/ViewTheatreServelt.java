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
@WebServlet("/viewtheatre")
public class ViewTheatreServelt extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession session=req.getSession(false);
	    String  customername=(String)session.getAttribute("uname");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
	    out.println("<style type=\"text/css\">\r\n" + 
	    		"\r\n" + 
	    		"}\r\n" + 
	    		"* {\r\n" + 
	    		"	-webkit-transition-property: all;\r\n" + 
	    		"	-webkit-transition-duration: .2s;\r\n" + 
	    		"  -moz-transition-timing-function: cubic-bezier(100,50,21,6);\r\n" + 
	    		"	-moz-transition-property: all;\r\n" + 
	    		"  -moz-transition-timing-function: cubic-bezier(100,50,21,6);\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"body{\r\n" + 
	    		"  background:#3e3e59;\r\n" + 
	    		"  padding:75px;\r\n" + 
	    		"  text-align:center;\r\n" + 
	    		"  font-family: 'Oswald', sans-serif;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"h1{\r\n" + 
	    		"  color:#c0c0c0;\r\n" + 
	    		"  font-weight:100;\r\n" + 
	    		"  margin-top:-50px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".btn{\r\n" + 
	    		"  color:#999;\r\n" + 
	    		"  background:rgba(0, 0, 0, 0.5);\r\n" + 
	    		"  padding:30px 40px;\r\n" + 
	    		"  font-size:12px;\r\n" + 
	    		"  text-decoration:none;\r\n" + 
	    		"  letter-spacing:2px;\r\n" + 
	    		"  text-transform:uppercase;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".btn:hover{\r\n" + 
	    		"  border:none;\r\n" + 
	    		"  background:rgba(0, 0, 0, 0.4);\r\n" + 
	    		"  background:#fff;\r\n" + 
	    		"  padding:40px 50px; #000;\r\n" + 
	    		"  color:#1b1b1b;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"</style>\r\n" + 
	    		"\r\n" + 
	    		"<meta charset=\"utf-8\">\r\n" + 
	    		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	    		" \r\n" + 
	    		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
	    		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n" + 
	    		"  \r\n" + 
	    		"</head>\r\n" + 
	    		"<body>\r\n" + 
	    		"\r\n" + 
	    		"<h1 align=center style=\"font-weight:bold;font-size:50px\">Welcome to Enjoy The Show  "+customername+" ...!!!</h1><hr color=\"white\">\r\n" + 
	    		"<h><h><br><br>\r\n" + 
	    		"<a href=\"customerhome\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Home</a>\r\n" + 
				"    <a href=\"viewtheatre\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Theatres</a>\r\n" + 
				"    <a href=\"viewmovies\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Movies</a>\r\n" + 
				"    <a href=\"booktickets\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Book Tickets</a>\r\n" + 
				"    <a href=\"viewcustomertickets\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Tickets</a>\r\n" + 
				"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"    <a href=\"customerlogin.html\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Logout</a>"+
				"   <br>\r\n" + 
	    		"<br>");	
		
		out.println("<style>\r\n" + 
				"	\r\n" + 
				"	@import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700');\r\n" + 
				"\r\n" + 
				"$base-spacing-unit: 24px;\r\n" + 
				"$half-spacing-unit: $base-spacing-unit / 2;\r\n" + 
				"\r\n" + 
				"$color-alpha: #1772FF;\r\n" + 
				"$color-form-highlight: #EEEEEE;\r\n" + 
				"\r\n" + 
				"*, *:before, *:after {\r\n" + 
				"	box-sizing:border-box;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body {\r\n" + 
				"	padding:$base-spacing-unit;\r\n" + 
				"	font-family:'Source Sans Pro', sans-serif;\r\n" + 
				"	margin:0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1,h2,h3,h4,h5,h6 {\r\n" + 
				"	margin:0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".container {\r\n" + 
				"	max-width: 1000px;\r\n" + 
				"	margin-right:auto;\r\n" + 
				"	margin-left:auto;\r\n" + 
				"	display:flex;\r\n" + 
				"	justify-content:center;\r\n" + 
				"	align-items:center;\r\n" + 
				"	min-height:100vh;\r\n" + 
				"	margin-top: -300px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".table {\r\n" + 
				"	width:100%;\r\n" + 
				"	height: 20px;\r\n" + 
				"	border:1px solid $color-form-highlight;\r\n" + 
				"	text-align:center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".table-header {\r\n" + 
				"	display:flex;\r\n" + 
				"	width:100%;\r\n" + 
				"	height: 30px;\r\n" + 
				"	background:#fe4164;\r\n" + 
				"	text-align:center;\r\n" + 
				"	padding:($half-spacing-unit * 1.5) 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".table-row {\r\n" + 
				"	display:flex;\r\n" + 
				"	width:100%;\r\n" + 
				"	height:35px;\r\n" + 
				"	padding:($half-spacing-unit * 1.5) 0;\r\n" + 
				"	text-align:center;\r\n" + 
				"	&:nth-of-type(odd) {\r\n" + 
				"		background:white;\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".table-data, .header__item {\r\n" + 
				"	flex: 1 1 20%;\r\n" + 
				"	text-align:center;\r\n" +
				
				"}\r\n" + 
				".table-data{\r\n" + 
				"		background:#fada5e;\r\n" + 
				
				"}\r\n" + 
				"\r\n" + 
				".header__item {\r\n" + 
				"	text-transform:uppercase;\r\n" + 
				"	text-align:center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"<div class=\"container\">\r\n" + 
				"	\r\n" + 
				"	<div class=\"table\">\r\n" + 
				"		<div class=\"table-header\">\r\n" + 
				"			<div class=\"header__item\"><b>ID</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>Name</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>Est Year</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>Address</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>Pincode</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>Capacity</b></div>\r\n" + 
				"			<div class=\"header__item\"><b>TicketPrice</b></div>\r\n" + 
				"		</div>");
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from theatre");	
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				out.println("<div class=\"table-content\">	\r\n" + 
						"			<div class=\"table-row\">		\r\n" + 
						"				<div class=\"table-data\">"+rs.getInt(1)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getString(2)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getInt(3)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getString(4)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getString(5)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getInt(6)+"</div>\r\n" + 
						"				<div class=\"table-data\">"+rs.getDouble(7)+"</div>\r\n" + 
						"			</div>\r\n" + 
						"		</div>	");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.println("</div>\r\n" + "</div>"
				+ "<body>");

	}	
}
