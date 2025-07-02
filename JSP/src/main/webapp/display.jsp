<%@page import="com.ty.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User Details</h1>

	<%
	String name = (String) request.getAttribute("userName");
	int age = (Integer) request.getAttribute("age");
	User user = (User) request.getAttribute("myUser");
	%>
	<%-- <h2>Name : <%=name %></h2>
	<h2>Age : <%=age %></h2> --%>

	<h2>
		Uid :
		<%=user.getUid()%></h2>
	<h2>
		Name :
		<%=user.getName()%></h2>
	<h2>
		Email :
		<%=user.getEmail()%></h2>

	<hr>

	<h2>UserName : ${userName}</h2>
	<h2>UserAge : ${age}</h2>

	<hr>

	<h2>UserId : ${myUser.uid}</h2>
	<h2>UserName : ${myUser.name}</h2>
	<h2>UserEmail : ${myUser.email}</h2>

</body>
</html>