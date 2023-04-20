<%
String aid = (String)session.getAttribute("aid");
String pwd = (String)session.getAttribute("pwd");
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

</html>