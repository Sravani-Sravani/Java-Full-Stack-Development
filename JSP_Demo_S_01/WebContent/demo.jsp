<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%!
int a=10,b=20;
int add(int x,int y)
{
	return x+y;
}
%>
<%
System.out.println(add(a,b));
out.println("<h1>Addition of a and b is a+b: "+add(a,b)+"<h1>");

%>

<h1><%=add(a,b) %></h1>

<%
try
{
Connection con=DBConnection.getConnection();
if(con!=null)
{
out.println("<h1>Connection established</h1>");	
}
}
catch(Exception e)
{
	
}
%>
