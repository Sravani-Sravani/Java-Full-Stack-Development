import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/updateticket")
public class UpdateTicketServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(false);
	    String  customername=(String)session.getAttribute("uname");
	    String bookingid=req.getParameter("bookingid");
	    session.setAttribute("bookingid",bookingid);
		out.println("<link href='https://fonts.googleapis.com/css?family=Oswald:300' rel='stylesheet' type='text/css'>\r\n" + 
				"<link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet' type='text/css'>");
	    out.println("<style type=\"text/css\">\r\n" + 
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
	    		"@import url('https://fonts.googleapis.com/css?family=Abel|Abril+Fatface|Alegreya|Arima+Madurai|Dancing+Script|Dosis|Merriweather|Oleo+Script|Overlock|PT+Serif|Pacifico|Playball|Playfair+Display|Share|Unica+One|Vibur');\r\n" + 
	    		"/* End Fonts */\r\n" + 
	    		"/* Start Global rules */\r\n" + 
	    		"* {\r\n" + 
	    		"    padding: 0;\r\n" + 
	    		"    margin: 0;\r\n" + 
	    		"    box-sizing: border-box;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"form {\r\n" + 
	    		"    width: 450px;\r\n" + 
	    		"    min-height: 375px;\r\n" + 
	    		"    height: auto;\r\n" + 
	    		"    border-radius: 5px;\r\n" + 
	    		"    margin: 2% auto;\r\n" + 
	    		"    box-shadow: 0 9px 50px hsla(20, 67%, 75%, 0.31);\r\n" + 
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
	    		"/*  A welcome message or an explanation of the login form */\r\n" + 
	    		"header p {letter-spacing: 0.05em;}\r\n" + 
	    		"\r\n" + 
	    		".input-item {\r\n" + 
	    		"    background: #fff;\r\n" + 
	    		"    color: #333;\r\n" + 
	    		"    padding: 14.5px 0px 15px 9px;\r\n" + 
	    		"    border-radius: 5px 0px 0px 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"/* Show/hide password Font Icon */\r\n" + 
	    		"/* inputs form  */\r\n" + 
	    		"input[class=\"form-input\"]{\r\n" + 
	    		"    width: 240px;\r\n" + 
	    		"    height: 50px;\r\n" + 
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
	    		"button {\r\n" + 
	    		"    display: inline-block;\r\n" + 
	    		"background: #B8F2E6;\r\n" + 
	    		"  \r\n" + 
	    		"    width: 280px;\r\n" + 
	    		"    height: 50px;\r\n" + 
	    		"  \r\n" + 
	    		"    padding: 0 20px;\r\n" + 
	    		"    background: #B8F2E6;\r\n" + 
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
	    		"    color: #252537;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/*       Forgot Password button FAF3DD  */\r\n" + 
	    		".frgt-pass {background: transparent;}\r\n" + 
	    		"\r\n" + 
	    		"/*     Sign Up button  */\r\n" + 
	    		".sign-up {background: #B8F2E6;\r\n" + 
	    		"width: 150px;\r\n" + 
	    		"    height: 30px;\r\n" + 
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
	    		"\r\n" + 
	    		"\r\n" + 
	    		"</style>\r\n" + 
	    		"</head>\r\n" + 
	    		"<body>\r\n" + 
	    		"\r\n" + 
	    		"<h1 align=center style=\"font-weight:bold;font-size:50px\">Welcome to Enjoy The Show "+customername+" ...!!!</h1><b><hr color=\"white\">\r\n" + 
	    		"<h><h><br><br><br>\r\n" + 
	    		"<a href=\"customerhome.html\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Home</a>\r\n" + 
	    		"    <a href=\"#\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Theatres</a>\r\n" + 
	    		"    <a href=\"#\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Movies</a>\r\n" + 
	    		"    <a href=\"#\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Book Tickets</a>\r\n" + 
	    		"    <a href=\"booktickets\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">View Tickets</a>\r\n" + 
	    		"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
	    		"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
	    		"    <a href=\"customerlogin.html\" class=\"btn\" style=\"font-weight:bold;font-size:15px\">Logout</a>\r\n" + 
	    		"    \r\n" + 
	    		"<br>\r\n" + 
	    		"<br>\r\n" + 
	    		"\r\n" + 
	    		"<div class=\"overlay\">\r\n" + 
	    		"\r\n" + 
	    		"<form method=\"post\" action=\"updateticket1\">\r\n" + 
	    		"   <!--   con = Container  for items in the form-->\r\n" + 
	    		"   <div class=\"con\">\r\n" + 
	    		"   <!--     Start  header Content  -->\r\n" + 
	    		"   <header class=\"head-form\">\r\n" + 
	    		"      <h2>Update Tickets</h2>\r\n" + 
	    		 
	    		"   </header>\r\n" + 
	    		"   <br>\r\n" + 
	    		"   <div class=\"field-set\">\r\n" + 
	    		"         <span class=\"input-item\">\r\n" + 
	    		"           <i class=\"fa fa-money\"></i>\r\n" + 
	    		"         </span>\r\n" + 
	    		"        <input class=\"form-input\" id=\"txt-input\" type=\"text\" placeholder=\"Tickets Count\" name=\"ticketscount\" required>\r\n" + 
	    		"     \r\n" + 
	    		"      <br>  \r\n" + 
	    		"<!--        buttons -->\r\n" + 
	    		"<!--      button LogIn -->\r\n" + 
	    		"      <button class=\"log-in\"> Update </button>\r\n" + 
	    		"   </div>\r\n" + 
	    		"  \r\n" + 
	   
	    		"</form>\r\n" + 
	    		"</div>\r\n" + 
	    		""
	    		+ "</body>");
			}
}
