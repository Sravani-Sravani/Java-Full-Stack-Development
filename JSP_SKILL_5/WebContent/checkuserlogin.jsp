<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%

String email = request.getParameter("email");
String pwd = request.getParameter("pwd");

try
{
	Connection con=DBConnection.getConnection();
	  
	  PreparedStatement pstmt = con.prepareStatement("select * from userreg where email=? and password=?");
	  pstmt.setString(1,email);
	  pstmt.setString(2,pwd);
	  ResultSet rs = pstmt.executeQuery();
	  if(rs.next())
	  {
		 session.setAttribute("fname", rs.getString("name"));
		 session.setAttribute("email", email);
		 session.setAttribute("pwd", pwd);
		 session.setMaxInactiveInterval(100);
		 response.sendRedirect("userhome.jsp");
	  }
	  else
	  {
		  %>
			<h3>Login Failed</h3><br>
	<a href="userlogin.html">Try Again</a>
			<% 
	  }
}
catch(Exception e)
{
	out.println(e);
}



%>