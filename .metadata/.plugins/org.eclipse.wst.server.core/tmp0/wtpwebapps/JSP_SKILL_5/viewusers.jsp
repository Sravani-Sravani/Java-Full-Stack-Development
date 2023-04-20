<%@ page import="java.util.*,java.sql.*,dbconnection.DBConnection" %>
<%
String aid = (String)session.getAttribute("aid");
String pwd = (String)session.getAttribute("pwd");
if(aid==null || pwd==null)
{
    response.sendRedirect("asession.html");
}
%>
<html>
    <style>
nav {
	margin: 27px auto 0;

	position: relative;
	width: 510px;
	height: 50px;
	background-color: #34495e;
	border-radius: 8px;
	font-size: 0;
}
nav a {
	line-height: 50px;
	height: 100%;
	font-size: 15px;
	display: inline-block;
	position: relative;
	z-index: 1;
	text-decoration: none;
	text-transform: uppercase;
	text-align: center;
	color: white;
	cursor: pointer;
}
nav .animation {
	position: absolute;
	height: 100%;
	top: 0;
	z-index: 0;
	transition: all .5s ease 0s;
	border-radius: 8px;
}
a:nth-child(1) {
	width: 110px;
}
a:nth-child(2) {
	width: 250px;
}
a:nth-child(3) {
	width: 150px;
}


nav .start-home, a:nth-child(1):hover~.animation {
	width: 110px;
	left: 0;
	background-color:	Crimson;
}
nav .start-about, a:nth-child(2):hover~.animation {
	width: 250px;
	left: 110px;
	background-color:SeaGreen;
}
nav .start-blog, a:nth-child(3):hover~.animation {
	width: 150px;
	left: 360px;
	background-color: Goldenrod;
}



body {
	font-size: 12px;
	font-family: sans-serif;
	background:#BC8F8F;
}
h1 {
	text-align: center;
	margin: 40px 0 40px;
	text-align: center;
	font-size: 30px;
	color: #ecf0f1;
	text-shadow: 2px 2px 4px #000000;
	font-family: 'Cherry Swash', cursive;
}

p {
    position: absolute;
    bottom: 20px;
    width: 100%;
    text-align: center;
    color: #ecf0f1;
    font-family: 'Cherry Swash',cursive;
    font-size: 16px;
}

span {
    color: #2BD6B4;
}
</style>
<h1 >JSP Application For JFSD Skilling-5</h1>

<nav>
	<a href="adminhome.jsp">Home</a>
	<a href="viewusers.jsp">View Users</a>
	<a href="alogout.jsp">Log Out</a>
	<div class="animation start-home"></div>
</nav>
        <h1 align=center>Welcome&nbsp;&nbsp;<%=aid%></h1><br>
<table  style="width: 1000px; margin-left: auto; margin-right: auto;border:2px solid darkblue;">
<tr align=center bgcolor="springgreen" style="line-height: 40px;border:2px solid tomato;width: 100%;
    max-width: 100%;border:2px solid tomato;">
<th>ID</th>
<th>FULL NAME</th>
<th>GENDER</th>
<th>USERNAME</th>
<th>EMAIL ID</th>
<th>MOBILE NO</th>
<th>ADDRESS</th>
<th>ACTION</th>
</tr>
<%
Connection con=DBConnection.getConnection();
 
 PreparedStatement pstmt = con.prepareStatement("select * from userreg");
ResultSet rs = pstmt.executeQuery();
 while(rs.next())
{
	%>
	<tr align=center bgcolor="tomato" style="line-height: 35px;border:2px solid springgreen;">
	<td><%=rs.getString("id")%></td>
	<td><%=rs.getString("name")%></td>
	<td><%=rs.getString("gender")%></td>
	<td><%=rs.getString("username")%></td>
	<td><%=rs.getString("email")%></td>
	<td><%=rs.getString("mobile")%></td>
	<td><%=rs.getString("address")%></td>
	<td>
	<a href="deleteuser.jsp?id=<%=rs.getString("id")%>">Delete</a>
	</td>
	</tr>
	<%
}

%>




</table>


    </body>
</html>



