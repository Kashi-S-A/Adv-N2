package com.ty.conn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			/*
			 * String sql = "INSERT INTO emp VALUES(?,?,?)";
			 * 
			 * PreparedStatement pstm = con.prepareStatement(sql); pstm.setInt(1, 104);
			 * pstm.setString(2, "John Doe"); pstm.setDouble(3, 45000);
			 * 
			 * pstm.execute();
			 */

			String sql = "call procedurename(?,?,?)";// Example for calling a stored procedure
			String sql1 = "select function_name(?,?,?)";// Example for calling a function

			CallableStatement cstm = con.prepareCall(sql);
			cstm.setInt(1, 105);
			cstm.setString(2, "Jane Doe");
			cstm.setDouble(3, 50000);

			cstm.execute();	

			con.close();

			System.out.println("Data inserted successfully");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
