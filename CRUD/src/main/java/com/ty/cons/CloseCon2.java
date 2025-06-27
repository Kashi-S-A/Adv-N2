package com.ty.cons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseCon2 {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/dem";
		String user = "postgres";
		String password = "root";

		try {
			// Step 1: Load the driver
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Step 2: Establish a connection
		try (Connection con = DriverManager.getConnection(url, user, password);) {

			System.out.println("Connection established successfully");

			// Step 3: Create a statement
			Statement stm = con.createStatement();
			System.out.println("Statement created successfully");

			// Step 4: Execute a query
			String query = "SELECT * FROM";

			stm.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
