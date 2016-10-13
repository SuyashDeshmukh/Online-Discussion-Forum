<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Register" method="post">
<center>

<jsp:include page="Header.jsp"></jsp:include>
<%
String message = (String)request.getAttribute("message");
if(message!=null)
	out.println(message);
%>
<table>
<tr>
<td>
<br><br><br>
<table class="style1">
            <tr>
                <td class="style3" colspan="2">
                    Register Form</td>
            </tr>
            <tr>
                <td class="style2">
                    Email ID :</td>
                <td>
                    <input name="email" type="text" id="TextBox1" />
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Password:</td>
                <td>
                    <input name="pswd" type="password" id="TextBox2" />
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Confirm Password:</td>
                <td>
                    <input name="cpswd" type="password" id="TextBox3" />
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Name:</td>
                <td>
                    <input name="name" type="text" id="TextBox4" />
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Gender:</td>
                <td>
                    <table id="RadioButtonList1" border="0">
	<tr>
		<td><input id="RadioButtonList1_0" type="radio" name="gender" value="male" /><label for="RadioButtonList1_0">Male</label></td><td><input id="RadioButtonList1_1" type="radio" name="gender" value="Female" /><label for="RadioButtonList1_1">Female</label></td>
	</tr>
</table>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Age:</td>
                <td>
                    <input name="age" type="text" id="TextBox5" />
                </td>
            </tr>
            <tr>
                <td class="style2">
                    City:</td>
                <td>
                    <input name="city" type="text" id="TextBox6" />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" name="Button1" value="Register" id="Button1" />
                </td>
            </tr>
        </table>
        <br><br><br><br><br>
</td>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</center>
</form>
</body>
</html>