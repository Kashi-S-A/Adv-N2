package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/demo";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			Statement stm = con.createStatement();

			String sql = "DELETE FROM emp WHERE eid = 103";

			boolean result = stm.execute(sql);
			System.out.println(result);

			con.close();

			System.out.println("Record deleted successfully and connection closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
