package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/demo";
		String user = "postgres";
		String password = "root";

		try {
			// Step 1: Load the driver
			Class.forName(driver);
			System.out.println("Driver loaded successfully");

			// Step 2: Establish a connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established successfully");

			// Step 3: Create a statement
			Statement stm = con.createStatement();
			System.out.println("Statement created successfully");

//			String sql = "INSERT INTO emp VALUES(107,'Tony',90000)";//1 row affected

			String sql = "DELETE FROM emp WHERE name = 'Tony'";// 3 rows affected

//			String sql = "SELECT * FROM emp";//Exception : A result was returned when none was expected.

			// Step 4: Execute the SQL query
//			boolean result = stm.execute(sql);

			int result = stm.executeUpdate(sql); // Use executeUpdate for INSERT, UPDATE, DELETE statements

			System.out.println("The no of rows affected : " + result);
			System.out.println("Record inserted successfully");

			// Step 5: Close the connection
			con.close();
			System.out.println("Connection closed successfully");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
