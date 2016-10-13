<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
ArrayList<Topic> topics = (ArrayList<Topic>)request.getAttribute("topics");
if(topics.size()>0)
{
	int i=1;


%>
<table>
<thead>
<th>S.No</th>
<th>Topic Name</th>
<th>First Comment</th>
<th>Time</th>
</thead>
<tbody>
<%
for(Topic topic:topics)
{



%>

<tr>
<td><%=i++%></td>
<td><%=topic.getTopicname() %></td>
<td><%=topic.getComment() %></td>
<td><%=topic.getDate() %></td>
<td>
<form action="EditTopic" method="post">
<input type="hidden" name="id" value="<%=topic.getTopicid() %>"> 
<input type="submit" value="Edit"></td>
</form>
</tr>
<%}} %>
</tbody>

</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>