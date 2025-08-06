<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expense List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 40px;
        }

        .container {
            max-width: 1000px;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            margin: auto;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table thead {
            background-color: #4CAF50;
            color: white;
        }

        table th, table td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        table tbody tr:hover {
            background-color: #f1f1f1;
        }

        .action-buttons a {
            margin-right: 8px;
            padding: 6px 12px;
            color: white;
            border-radius: 4px;
            text-decoration: none;
        }

        .edit-btn {
            background-color: #2196F3;
        }

        .delete-btn {
            background-color: #f44336;
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Expense List</h2>
        <table>
            <thead>
                <tr>
                    <th>Expense Name</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Lunch with Friends</td>
                    <td>15.00</td>
                    <td>09-08-2024</td>
                    <td>Lunch at the downtown café.</td>
                    <td class="action-buttons">
                        <a href="editExpense.jsp?id=1" class="edit-btn">Edit</a>
                        <a href="deleteExpense?id=1" class="delete-btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
                    </td>
                </tr>
                <tr>
                    <td>Grocery Shopping</td>
                    <td>45.90</td>
                    <td>07-08-2024</td>
                    <td>Bought weekly groceries from supermarket.</td>
                    <td class="action-buttons">
                        <a href="editExpense.jsp?id=2" class="edit-btn">Edit</a>
                        <a href="deleteExpense?id=2" class="delete-btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
                    </td>
                </tr>
                <tr>
                    <td>Electricity Bill</td>
                    <td>1200.00</td>
                    <td>05-08-2024</td>
                    <td>Monthly electricity bill payment.</td>
                    <td class="action-buttons">
                        <a href="editExpense.jsp?id=3" class="edit-btn">Edit</a>
                        <a href="deleteExpense?id=3" class="delete-btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
                    </td>
                </tr>
                <!-- Add more dummy rows as needed -->
            </tbody>
        </table>

        <a href="welcome.jsp" class="back-link">← Back to Dashboard</a>
    </div>
</body>
</html>
