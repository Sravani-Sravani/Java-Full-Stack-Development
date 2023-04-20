<%@ page import="dbconnection.Student,java.util.*,java.sql.*,dbconnection.DBConnection" %>

<%

Student StudentBean=(Student)request.getAttribute("StudentBean");

%>

<h1><b>Student Id: <%=StudentBean.getId() %></b></h1>
<h1><b>Student Name: <%=StudentBean.getName() %></b></h1>
<h1><b>Student Gender: <%=StudentBean.getGender() %></b></h1>
<h1><b>Student Age: <%=StudentBean.getAge() %></b></h1>