package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

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

			String sql = "SELECT * FROM emp";

			// Step 4: Execute the SQL query
			ResultSet rs = stm.executeQuery(sql);

			System.out.println("=============Employees=============");

			while (rs.next()) {
				System.out.println("eid : " + rs.getInt(1));
				System.out.println("ename : " + rs.getString(2));
				System.out.println("salary : " + rs.getDouble(3));
				System.out.println("--------------------------------");
			}

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
