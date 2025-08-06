<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .register-container {
            background-color: white;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 300px;
        }

        .register-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .register-container label {
            display: block;
            margin-bottom: 5px;
        }

        .register-container input[type="text"],
        .register-container input[type="password"],
        .register-container input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .register-container button {
            width: 100%;
            background-color: #337ab7;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .register-container button:hover {
            background-color: #286090;
        }

        .register-container .login-link {
            text-align: center;
            margin-top: 15px;
        }

        .register-container .login-link a {
            color: blue;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Registration</h2>
        <form action="register" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullName" required>

            <button type="submit">Register</button>
        </form>
        <div class="login-link">
          <a href="/"> Already have an account ? Login here</a>
        </div>
    </div>
</body>
</html>
