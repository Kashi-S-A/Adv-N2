<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = request.getParameter("un");
	String email = request.getParameter("ue");
	String password = request.getParameter("up");
	%>

	<h1><%=name %>, Welcome to Read Page</h1>
	<h3>You have registered to our app with email : <%=email %></h3>
</body>
</html>