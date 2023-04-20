<h1>
Login Successful
</h1>

<%@ page import="com.klef.Employee"%>

<%
Employee emp=(Employee)request.getAttribute("empbean");

%>

Welcome <%=emp.getUsername()%>