package com.ty.cons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseCon1 {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/demo";
		String user = "postgres";
		String password = "root";

		Connection con = null;

		try {
			// Step 1: Load the driver
			Class.forName(driver);
			System.out.println("Driver loaded successfully");

			// Step 2: Establish a connection
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println(con);
			System.out.println("Connection established successfully");

			// Step 3: Create a statement
			Statement stm = con.createStatement();
			System.out.println("Statement created successfully");

			// Step 4: Execute a query
			String query = "SELECT * FROM";

			stm.executeQuery(query);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection closed successfully");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
