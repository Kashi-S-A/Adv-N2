package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Demo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Demo servlet is called");

		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Welcome to Demo Servlet</title></head>");
		pw.println("<body>");
		pw.println("<h1>Welcome to Demo Servlet</h1>");
		pw.println("<p>This is a simple servlet example.</p>");
		pw.println("</body>");
		pw.println("</html>");

	}
}
