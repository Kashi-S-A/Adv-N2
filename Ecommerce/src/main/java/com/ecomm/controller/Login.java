package com.ecomm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecomm.db.ConnectionPool;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String sql = "SELECT * FROM users WHERE email=? AND password=?";

		Connection con = ConnectionPool.giveConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			ConnectionPool.submitConnection(con);
			
			if (rs.next()) {
				//Login succ
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			} else {
				//invalid credentials
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				req.setAttribute("errmsg", "Invalid credentials");
				rd.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("msg", "something went wrong please try again later!!");
			rd.forward(req, resp);
		}
	}
}
