<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%
String fname = (String)session.getAttribute("fname");
String email = (String)session.getAttribute("email");
String pwd = (String)session.getAttribute("pwd");
%>
<%

String opwd = request.getParameter("opwd");
String npwd = request.getParameter("npwd");

try
{
	  Connection con=DBConnection.getConnection();
	  PreparedStatement pstmt = con.prepareStatement("select * from userreg where email=? and password=?");
	  pstmt.setString(1,email);
	  pstmt.setString(2,opwd);
	  ResultSet rs = pstmt.executeQuery();
	  if(rs.next())
	  {
		  PreparedStatement pstmt1 = con.prepareStatement("update userreg set password=? where email=?");
		  pstmt1.setString(1,npwd);
		  pstmt1.setString(2,email);
		  int i = pstmt1.executeUpdate();
		  if(i>0)
		  {
			  response.sendRedirect("userlogin.html");
		  }
		  else
		  {
			  %>
			<h3>Password has not been updated</h3><br>
	<a href="changepwd.jsp">Try Again</a>
				<%   
		  }
	  }
	  else
	  {
		  %>
			<h3>Current Password is incorrect</h3><br>
	<a href="changepwd.jsp">Try Again</a>
			<% 
	  }
}
catch(Exception e)
{
	out.println(e);
}



%>