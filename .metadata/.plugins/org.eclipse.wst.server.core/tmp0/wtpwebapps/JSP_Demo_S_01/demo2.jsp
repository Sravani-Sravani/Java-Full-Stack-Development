<h1>In Demo2 JSP File</h1>

<h1>The Parameters:</h1>



<%

int id = Integer.parseInt(request.getParameter("id"));



String name = request.getParameter("name");



out.println("<h1> ID:"+id+", NAME:"+name+"</h1>");



%>