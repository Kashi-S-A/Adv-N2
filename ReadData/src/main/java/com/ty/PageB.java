package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageb")
public class PageB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String pwd = req.getParameter("userPwd");

		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Password: " + pwd);

		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("<h1>Welcome to Page B</h1>");
		out.println("<p>Name: " + name + "</p>");
		out.println("<p>Email: " + email + "</p>");
		out.println("</body></html>");

	}
}