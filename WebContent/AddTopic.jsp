<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>

 <%
String message = (String)request.getAttribute("message");
if(message!=null)
	out.println(message);
%>
<br>

</center>
<form action="AddTopic" method="post">
        <table class="style1" cellspacing="20">
            <tr>
                <td>
                    Menu :</td>
                     <td>
                    &nbsp;</td>
                
                    <td>Add Topic</td>
            </tr>
            <tr>
                <td>
                   <a href="AddTopic"> Add Topic</a></td>
                <td>
                    &nbsp;</td>
                    <td>Topic:</td>
                    <td><input type="text" name="topic"></td>
            </tr>
            <tr>
                <td>
                   <a href="MyTopics"> My topics</a></td>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td>
                    <a href="ListTopics">List Topics</a></td>
                     <td>
                    &nbsp;</td>
                <td>
                
                    Content :</td>
                    <td>
                    <textarea rows =5 cols = 20 name ="Comment"></textarea>
            </tr>
            
            <tr>
                <td>
                    <a href="SearchTopic">Search Topic</a></td>
                <td>
                    &nbsp;</td>
                     <td>
                    &nbsp;</td>
                    <td>
                    
                    <input type="submit" >
                   
            	</td>
            </tr>
            <tr>
                <td>
                    <a href="SignOut">Sign Out</a></td>
                <td>
                    &nbsp;</td>
            </tr>
        </table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>