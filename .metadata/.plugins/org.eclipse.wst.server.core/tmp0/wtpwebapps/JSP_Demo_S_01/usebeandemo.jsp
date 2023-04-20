<jsp:useBean id="studentinfo" class="dbconnection.Student"></jsp:useBean>
<h1>Student Details:</h1>
<jsp:setProperty name="studentinfo" property="*"/>
<h1>Student Id:<jsp:getProperty name="studentinfo" property="id"/></h1>
<h1>Student Name:<jsp:getProperty name="studentinfo" property="name"/></h1>
<h1>Student Gender:<jsp:getProperty name="studentinfo" property="gender"/></h1>
<h1>Student Age:<jsp:getProperty name="studentinfo" property="age"></jsp:getProperty></h1>
