<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<table>
<tr>
<td><img  src="Images/1.gif" width="300">
</td>
<td><img  src="Images/2.jpg" width="300">
</td>
<td><img  src="Images/3.bmp" width="300">
</td>
</tr>
<tr align="left">
<td><a href ="Home.jsp">Home</a>
&nbsp;&nbsp;&nbsp;
<a href="Login.jsp">Login</a> 
&nbsp;&nbsp;&nbsp;
<a href="register.jsp">Register</a>
</td>
</tr>
</table>
<%
User user=(User)session.getAttribute("user");
if(user!=null)
	out.println("Hello,"+user.getName());
%>
<center>

</center>
</body>
</html>