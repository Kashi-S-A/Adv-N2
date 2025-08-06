<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Expense Tracker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .welcome-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
            width: 80%;
            max-width: 800px;
        }

        .welcome-container h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .nav-links {
            margin-bottom: 20px;
        }

        .nav-links a {
            margin: 0 15px;
            text-decoration: none;
            color: green;
            font-weight: bold;
        }

        .nav-links a:hover {
            text-decoration: underline;
        }

        .description {
            font-size: 14px;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h1>Welcome to Expense Tracker</h1>
        <div class="nav-links">
            <a href="addExpense.jsp">Add Expense</a>
            <a href="expenseList.jsp">Expense List</a>
        </div>
        <p class="description">
            Track and manage your expenses effectively. Use the navigation links to add new expenses or view your expense history.
        </p>
    </div>
</body>
</html>
