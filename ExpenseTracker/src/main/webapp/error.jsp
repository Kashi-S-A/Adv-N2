<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-container {
            background-color: #f5c6cb;
            padding: 30px 40px;
            border: 1px solid #f5c2c7;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }

        .error-container h1 {
            margin: 0 0 15px;
            font-size: 24px;
        }

        .error-container a {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 20px;
            background-color: #721c24;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .error-container a:hover {
            background-color: #501517;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Something went wrong</h1>
        <p>Please try again later or <a href="/">login again</a>.</p>
    </div>
</body>
</html>
