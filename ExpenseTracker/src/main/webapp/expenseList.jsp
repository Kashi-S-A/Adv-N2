<%@page import="com.et.entity.Expense"%>
<%@page import="java.util.List"%>
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

	<%
		List<Expense> exps =(List<Expense>) request.getAttribute("exps");
	%>

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
                
                <%
                	if(exps!=null){
                	for(Expense expense : exps)
                	{
                %>
                <tr>
                    <td><%=expense.getName()%></td>
                    <td><%=expense.getAmount()%></td>
                    <td><%=expense.getCreatedDate()%></td>
                    <td><%=expense.getDescription()%></td>
                    <td class="action-buttons">
                        <a href="editExpense.jsp?id=1" class="edit-btn">Edit</a>
                        <a href="deleteExpense?id=1" class="delete-btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
                    </td>
                </tr>
                <%
                	}
                	}
                	else{
                		 response.sendRedirect("/");
                	}
                %>
                <!-- Add more dummy rows as needed -->
            </tbody>
        </table>

       <br><br>
        <form action="filter">
        	 <label for="date1">From Date:</label>
            <input type="date" id="date1" name="fromDate" value="${from}" required>

            <label for="date2">To Date:</label>
            <input type="date" id="date2" name="toDate" value="${to}"  required>
            
            <input type="submit" value="Search">
        </form>
         <a href="welcome.jsp" class="back-link">← Back to Dashboard</a>
    </div>
</body>
</html>
