<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>

<%
String fname = request.getParameter("fname");
String gender = request.getParameter("gender");
String uname = request.getParameter("uname");
String pwd = request.getParameter("pwd");
String mobile = request.getParameter("mobile");
String email = request.getParameter("email");
String address = request.getParameter("address");
int id = (int)(Math.random() * 99999 + 1);
try
{
	Connection con=DBConnection.getConnection();
	 PreparedStatement ps = con.prepareStatement("select * from userreg where username=? or email=? ");
	 ps.setString(1, uname);
	 ps.setString(2, email);
	 ResultSet rs = ps.executeQuery();
	 
	 if(rs.next())
	 {
		 %>
	<h3>Email Id / Username already available</h3><br>
	<a href="reg.html">Try Again</a>
			<%  
	 }
	 else
	 {
		 PreparedStatement pstmt = con.prepareStatement("insert into userreg values(?,?,?,?,?,?,?,?)");
		 pstmt.setInt(1, id);
		 pstmt.setString(2, fname);
		 pstmt.setString(3, gender);
		 pstmt.setString(4, uname);
		 pstmt.setString(5, email);
		 pstmt.setString(6, pwd);
		 pstmt.setString(7, mobile);
		 pstmt.setString(8, address);
		 int i = pstmt.executeUpdate();
		 if(i>0)
		 {
	
	response.sendRedirect("userlogin.html");
		 }
		 else
		 {
				%>
				<h3>User Registration UnSuccessful</h3><br>
		<a href="reg.html">Try to Register Again</a>
				<% 
		 }
	 }
}
catch(Exception e)
{
	out.println(e);
}

%>