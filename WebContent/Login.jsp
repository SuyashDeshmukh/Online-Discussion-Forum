<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<jsp:include page="Header.jsp"></jsp:include>
<table>
<tr>
<td>
<br>
<br>
<br>
<%
String message = (String)request.getAttribute("message");
if(message!=null)
	out.println(message);
%>
<form action="Login" method="post">
<table class="style1">
        <tr>
            <td class="style2" colspan="2">
&nbsp; LOGIN FORM</td>
        </tr>
        <tr>
            <td class="style3">
                Email ID :</td>
            <td>
                <input name="email" type="text" id="TextBox1" />
            </td>
        </tr>
        <tr>
            <td class="style3">
                Password :</td>
            <td>
                <input name="password" type="password" id="TextBox2" />
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <input type="submit" name="Button1" value="LOGIN" id="Button1" />
            </td>
        </tr>
    </table>
	</form>    
</td>
</tr>
<tr>
<td>
<br><br><br><br><br>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</center>
</body>
</html>