<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var="a" value="1"></c:set>

	<c:out value="${a}"></c:out>
	<br>

	<c:choose>
		<c:when test="${a==10}">Hello World</c:when>
		<c:when test="${a>10}">How are you?</c:when>
		<c:otherwise>Hello Good Evening</c:otherwise>
	</c:choose>

	<c:redirect url="https://www.instagram.com/"></c:redirect>
</body>
</html>
