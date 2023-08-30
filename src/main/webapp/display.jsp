<%@page import="Model.DtoClass"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Object res=request.getAttribute("result"); %>
<% ArrayList<DtoClass> data=(ArrayList<DtoClass>) res;%>
<table border="1",align="center" rules="all">
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Employee Salary</th>
</tr>
<% for(DtoClass list:data){ %>
<tr>
<td><%= list.getId() %></td>
<td><%= list.getName()%></td>
<td><%= list.getSal()%></td>
</tr>
<%} %>
</table>
</body>
</html>