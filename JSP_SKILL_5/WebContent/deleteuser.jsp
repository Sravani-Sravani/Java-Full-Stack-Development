<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%
String aid = (String)session.getAttribute("aid");
String pwd = (String)session.getAttribute("pwd");
if(aid==null || pwd==null)
{
    response.sendRedirect("asession.html");
}
%>
<%
String id = request.getParameter("id");
%>
<%
 Connection con=DBConnection.getConnection();
 PreparedStatement pstmt = con.prepareStatement("delete from userreg where id=?");
 pstmt.setString(1,id);
 pstmt.executeUpdate();
 response.sendRedirect("viewusers.jsp");

%>