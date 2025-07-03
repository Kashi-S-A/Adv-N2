package com.ecomm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/ShopIt?user=postgres&password=root";
	private static final int POOL_SIZE = 5;
	private static final List<Connection> CONNECTIONPOOL = new ArrayList<Connection>();

	static {
		for (int i = 1; i <= POOL_SIZE; i++) {
			CONNECTIONPOOL.add(createConnection());
		}
	}

	private static Connection createConnection() {

		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection giveConnection() {
		if (!CONNECTIONPOOL.isEmpty()) {
			return CONNECTIONPOOL.remove(0);
		} else {
			return createConnection();
		}
	}

	public static void submitConnection(Connection con) {
		if (CONNECTIONPOOL.size() < POOL_SIZE) {
			CONNECTIONPOOL.add(con);
		} else {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
