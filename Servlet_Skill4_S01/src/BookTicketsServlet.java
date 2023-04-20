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
@WebServlet("/booktickets")
public class BookTicketsServlet extends HttpServlet 
{
	 public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	  {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    RequestDispatcher rd=req.getRequestDispatcher("customermenu.html");
	    rd.include(req,res);
	    out.println("<link href='https://fonts.googleapis.com/css?family=Oswald:300' rel='stylesheet' type='text/css'>\r\n" + 
	    		"<link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet' type='text/css'>");
	    out.println("<style>@import url('https://fonts.googleapis.com/css?family=Abel|Abril+Fatface|Alegreya|Arima+Madurai|Dancing+Script|Dosis|Merriweather|Oleo+Script|Overlock|PT+Serif|Pacifico|Playball|Playfair+Display|Share|Unica+One|Vibur');\r\n" + 
	    		"\r\n" + 
	    		"* {\r\n" + 
	    		"    padding: 0;\r\n" + 
	    		"    margin: 0;\r\n" + 
	    		"    box-sizing: border-box;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"form {\r\n" + 
	    		"    width: 450px;\r\n" + 
	    		"    min-height: 350px;\r\n" + 
	    		"    height: auto;\r\n" + 
	    		"    border-radius: 5px;\r\n" + 
	    		"    margin: 2% auto;\r\n" + 
	    		"    box-shadow: 0 7px 30px hsla(20, 67%, 55%, 0.31);\r\n" + 
	    		"    padding: 2%;\r\n" + 
	    		"    background-image: linear-gradient(-225deg, #E3FDF5 50%, #FFE6FA 50%);\r\n" + 
	    		"}\r\n" + 
	    		"/* form Container */\r\n" + 
	    		"form .con {\r\n" + 
	    		"    display: -webkit-flex;\r\n" + 
	    		"    display: flex;\r\n" + 
	    		"  \r\n" + 
	    		"    -webkit-justify-content: space-around;\r\n" + 
	    		"    justify-content: space-around;\r\n" + 
	    		"  \r\n" + 
	    		"    -webkit-flex-wrap: wrap;\r\n" + 
	    		"    flex-wrap: wrap;\r\n" + 
	    		"  \r\n" + 
	    		"      margin: 0 auto;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/* the header form form */\r\n" + 
	    		"header {\r\n" + 
	    		"    margin: 2% auto 10% auto;\r\n" + 
	    		"    text-align: center;\r\n" + 
	    		"}\r\n" + 
	    		"/* Login title form form */\r\n" + 
	    		"header h2 {\r\n" + 
	    		"    font-size: 250%;\r\n" + 
	    		"    font-family: 'Playfair Display', serif;\r\n" + 
	    		"    color: #3e403f;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"header p {letter-spacing: 0.05em;}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		".input-item {\r\n" + 
	    		"    background: #fff;\r\n" + 
	    		"    color: #333;\r\n" + 
	    		"    padding: 13px 0px 13px 7px;\r\n" + 
	    		"    border-radius: 4px 0px 0px 4px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"/* inputs form  */\r\n" + 
	    		"input[class=\"form-input\"]{\r\n" + 
	    		"    width: 240px;\r\n" + 
	    		"    height: 40px;\r\n" + 
	    		"  \r\n" + 
	    		"    margin-top: 2%;\r\n" + 
	    		"    padding: 15px;\r\n" + 
	    		"    \r\n" + 
	    		"    font-size: 16px;\r\n" + 
	    		"    font-family: 'Abel', sans-serif;\r\n" + 
	    		"    color: #5E6472;\r\n" + 
	    		"  \r\n" + 
	    		"    outline: none;\r\n" + 
	    		"    border: none;\r\n" + 
	    		"  \r\n" + 
	    		"    border-radius: 0px 5px 5px 0px;\r\n" + 
	    		"    transition: 0.2s linear;\r\n" + 
	    		"    \r\n" + 
	    		"}\r\n" + 
	    		"input[id=\"txt-input\"] {width: 250px;}\r\n" + 
	    		"/* focus  */\r\n" + 
	    		"input:focus {\r\n" + 
	    		"    transform: translateX(-2px);\r\n" + 
	    		"    border-radius: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/* input[type=\"text\"] {min-width: 250px;} */\r\n" + 
	    		"/* buttons  */\r\n" + 
	    		"button {\r\n" + 
	    		"    display: inline-block;\r\n" + 
	    		"    color: #252537;\r\n" + 
	    		"  \r\n" + 
	    		"    width: 280px;\r\n" + 
	    		"    height: 50px;\r\n" + 
	    		"  \r\n" + 
	    		"    padding: 0 20px;\r\n" + 
	    		"   background: #B8F2E6;\r\n" + 
	    		"    border-radius: 5px;\r\n" + 
	    		"    \r\n" + 
	    		"    outline: none;\r\n" + 
	    		"    border: none;\r\n" + 
	    		"  \r\n" + 
	    		"    cursor: pointer;\r\n" + 
	    		"    text-align: center;\r\n" + 
	    		"    transition: all 0.2s linear;\r\n" + 
	    		"    \r\n" + 
	    		"    margin: 7% auto;\r\n" + 
	    		"    letter-spacing: 0.05em;\r\n" + 
	    		"}\r\n" + 
	    		"/* Submits */\r\n" + 
	    		".submits {\r\n" + 
	    		"    width: 48%;\r\n" + 
	    		"    display: inline-block;\r\n" + 
	    		"    float: left;\r\n" + 
	    		"    margin-left: 2%;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"/* buttons hover */\r\n" + 
	    		"button:hover {\r\n" + 
	    		"    transform: translatey(3px);\r\n" + 
	    		"    box-shadow: none;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/* buttons hover Animation */\r\n" + 
	    		"button:hover {\r\n" + 
	    		"    animation: ani9 0.4s ease-in-out infinite alternate;\r\n" + 
	    		"}\r\n" + 
	    		"@keyframes ani9 {\r\n" + 
	    		"    0% {\r\n" + 
	    		"        transform: translateY(3px);\r\n" + 
	    		"    }\r\n" + 
	    		"    100% {\r\n" + 
	    		"        transform: translateY(5px);\r\n" + 
	    		"    }\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"select {\r\n" + 
	    		"  // A reset of styles, including removing the default dropdown arrow\r\n" + 
	    		"  appearance: none;\r\n" + 
	    		"  // Additional resets for further consistency\r\n" + 
	    		"  background-color: transparent;\r\n" + 
	    		"  border: none;\r\n" + 
	    		"  height:40px;\r\n" + 
	    		"  width:245px;\r\n" + 
	    		"  margin: 0;\r\n" + 
	    		"   font-family: 'Abel', sans-serif;\r\n" + 
	    		"    font-size: 16px;\r\n" + 
	    		"  cursor: inherit;\r\n" + 
	    		"  line-height: inherit;\r\n" + 
	    		" text-align: center;\r\n" + 
	    		" color: #5E6472;\r\n" + 
	    		" \r\n" + 
	    		"  \r\n" + 
	    		"}</style>");
	    
	    out.print("<div class=\"overlay\">\r\n" + 
	    		"\r\n" + 
	    		"<form method=\"post\" action=\"bookticket1\">\r\n" + 
	    		"   <div class=\"con\">\r\n" + 
	    		"   <header class=\"head-form\">\r\n" + 
	    		"      <h2>Ticket Booking</h2>\r\n" + 
	    		"   </header>\r\n" + 
	    		"  \r\n" + 
	    		"   <div class=\"field-set\">");
	   HttpSession session=req.getSession(false);
	   String uname=(String)session.getAttribute("uname");
	    out.println("<span class=\"input-item\">\r\n" + 
	    		"           <i class=\"fa fa-user-circle\"></i>\r\n" + 
	    		"         </span>\r\n" + 
	    		"         <input class=\"form-input\" id=\"txt-input\" type=\"text\" value="+uname+" required>\r\n" + 
	    		"      <br> ");
	    
	    try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from movie");	
			ResultSet rs = pstmt.executeQuery();
			out.println("<br><span class=\"input-item\">\r\n" + 
					"           <i class=\"fa fa-film\"></i>\r\n" + 
					"         </span>\r\n" + 
					"        <select id=\"standard-select\" name=\"movieid\" required>\r\n" + 
					"          <option value=\"choose\" align=center style=\"text-align: center;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select Movie</option>\r\n" + 
					"");
			while(rs.next())
			{
				out.println( 
						"    <option value=\""+rs.getInt("movieid")+"\" align=center style=\"text-align: center;\">"+rs.getString("name")+"</option>\r\n" );
			}
			out.println("</select>\r\n" + 
					"      <br>  ");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	    try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from theatre");	
			ResultSet rs = pstmt.executeQuery();
			out.println("<br><span class=\"input-item\">\r\n" + 
					"           <i class=\"fa fa-film\"></i>\r\n" + 
					"         </span>\r\n" + 
					"        <select id=\"standard-select\" name=\"theatreid\" required>\r\n" + 
					"          <option value=\"choose\" align=center style=\"text-align: center;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select Theatre</option>\r\n" + 
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
	    
	    out.println("<br><span class=\"input-item\">\r\n" + 
	    		"           <i class=\"fa fa-calendar\" aria-hidden=\"true\" style=\"font-size:18px\"></i>\r\n" + 
	    		"         </span>\r\n" + 
	    		"         <input class=\"form-input\" id=\"txt-input\" type=\"date\" name=\"showdate\" required>\r\n" + 
	    		"      <br>  ");
	    out.println("<br><span class=\"input-item\">\r\n" + 
	    		"           <i class=\"fa fa-clock-o\"></i>\r\n" + 
	    		"         </span>\r\n" + 
	    		"        <select id=\"standard-select\" name=\"showslot\" required>\r\n" + 
	    		"          <option value=\"choose\" align=center style=\"text-align: center;\">&nbsp;&nbsp;&nbsp;Select slot</option>\r\n" + 
	    		"    <option value=\"9:00 AM\" align=center style=\"text-align: center;\">9:00 AM</option>\r\n" + 
	    		"    <option value=\"1:00 PM\">1:00 PM</option>\r\n" + 
	    		"    <option value=\"6:30 PM\">6:30 PM</option>\r\n" + 
	    		"    <option value=\"9:30 PM\">9:30 PM</option>\r\n" + 
	    		"  </select>\r\n" + 
	    		"      <br>  ");
	    out.println("<br><span class=\"input-item\">\r\n" + 
	    		"           <i class=\"fa fa-money\" aria-hidden=\"true\" style=\"font-size:18px\"></i>\r\n" + 
	    		"         </span>\r\n" + 
	    		"         <input class=\"form-input\" id=\"txt-input\" type=\"text\" placeholder=\"Tickets Count\" name=\"ticketscount\" required>\r\n" + 
	    		"      <br> ");
	    out.println("<button class=\"log-in\">Book Now</button>\r\n" + 
				"   </div>\r\n" + 
				"  </div>\r\n" + 
				"</form>\r\n" + 
				"</div>");
	    
	    
	    
	    
	    
	    
	    
	  }
}
