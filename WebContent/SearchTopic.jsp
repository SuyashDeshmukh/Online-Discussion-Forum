<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchTopic" method="post">

<jsp:include page="Header.jsp"></jsp:include>
<table>
<tr>
<td>
Search:
</td>
<td>
 <input name="pass" type="text" id="pass">
</td>
<td>

<input type="submit" name="Sch" value="Search">
</form>
</td>
</tr>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>