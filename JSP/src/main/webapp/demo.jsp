<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Jsp Tags:</h1>

	<!-- Declaration Tag : -->
	<%!
		int age = 10;
		static String name="Allen";
		
		public String getDetails(){
			return "[Name : "+name+", Age : "+age+"]";
		}
		
	%>
	
	<!-- Expression Tag: -->
	
	<h3>Age : <%=age %></h3>
	
	<h3>Name : <%=name %></h3>
	
	<h3>Output : <%=getDetails() %></h3>
	
	<!-- Scriptlet Tag -->
	
	<%
		int a= 10;//local variable
		
		out.println("Hello");
	%>
	<hr>
	<%
		out.println("Hello World");
	%>
	
	<%
		for(int i= 0;i<=5;i++){
	%>
	<h3>Hellooo</h3>
	<%
		}
	%>

</body>
</html>








