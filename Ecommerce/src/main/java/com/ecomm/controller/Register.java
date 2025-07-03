package com.ecomm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecomm.db.ConnectionPool;

@WebServlet("/reg")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String sql = "INSERT INTO users VALUES(?,?,?)";

		Connection connection = ConnectionPool.giveConnection();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, password);

			int saved = pstm.executeUpdate();
			
			ConnectionPool.submitConnection(connection);

			if (saved > 0) {
				// registered succ
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				req.setAttribute("msg", "Registered Successfully");
				rd.forward(req, resp);
			} else {
				// failed to reg
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				req.setAttribute("errmsg", "Failed Registered");
				rd.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// already saved
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("msg", "Already Registered");
			rd.forward(req, resp);
		}

	}
}
