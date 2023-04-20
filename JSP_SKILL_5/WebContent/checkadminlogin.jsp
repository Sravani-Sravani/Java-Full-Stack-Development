<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%

String aid = request.getParameter("aid");
String pwd = request.getParameter("pwd");

try
{
	  Connection con=DBConnection.getConnection();
	  PreparedStatement pstmt = con.prepareStatement("select * from admin where id=? and password=?");
	  pstmt.setString(1,aid);
	  pstmt.setString(2,pwd);
	  ResultSet rs = pstmt.executeQuery();
	
	  if(rs.next())
	  {
		 session.setAttribute("aid", aid);
		 session.setAttribute("pwd", pwd);
		 response.sendRedirect("adminhome.jsp");
	  }
	  else
	  {
		  %>
			<h3>Login Failed</h3><br>
	<a href="adminlogin.html">Try Again</a>
			<% 
	  }
}
catch(Exception e)
{
	out.println(e);
}



%>