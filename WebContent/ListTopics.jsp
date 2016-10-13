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
<th>S.No&nbsp;</th>
<th>Userid&nbsp;</th>
<th>Topic Name&nbsp;</th>
<th>First Comment&nbsp;</th>
<th>Time&nbsp;</th>
</thead>
<tbody>
<%
for(Topic topic:topics)
{



%>

<tr>
<td><%=i++%>&nbsp;</td>
<td><%=topic.getUserid() %>&nbsp;</td>
<td><%=topic.getTopicname() %>&nbsp;</td>
<td><%=topic.getComment() %>&nbsp;</td>
<td><%=topic.getDate() %>&nbsp;</td>

</tr>
<%}} %>
</tbody>

</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>