<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Expense</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            display: flex;
            justify-content: center;
            align-items: center;
            padding-top: 50px;
        }

        .form-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            width: 600px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-size: 14px;
        }

        textarea {
            resize: vertical;
            min-height: 80px;
        }

        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Expense</h2>
        <form action="updateExpense" method="post">
            <input type="hidden" name="eid" value="${expense.eid}" />

            <label for="name">Expense Name:</label>
            <input type="text" id="name" name="name" value="${expense.name}" required>

            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" value="${expense.amount}" required>

            <label for="date">Date:</label>
            <input type="date" id="date" name="updateDate" value="${expense.updateDate}" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${expense.description}</textarea>

            <button type="submit">Update Expense</button>
        </form>
    </div>
</body>
</html>
