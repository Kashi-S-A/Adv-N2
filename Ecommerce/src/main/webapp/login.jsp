<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f2f2f2;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background: white;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
	width: 300px;
}

h2 {
	text-align: center;
	margin-bottom: 25px;
}

input[type="email"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin: 8px 0 20px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 12px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Login</h2>
		<h3 style="color:green">${msg}</h3>
		<h3 style="color:red">${errmsg}</h3>
		<form action="login" method="post">
			<input type="email" name="email" placeholder="Email Address" required>
			<input type="password" name="password" placeholder="Password"
				required> <input type="submit" value="Login">
		</form>
		<br> <a href="register.jsp">Register/Sign up Here</a>
	</div>
</body>
</html>
