package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hi")
public class PageA extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String pwd = req.getParameter("userPwd");

		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Page A</title></head>");
		out.println("<body>");
		out.println("<h1>Welcome " + name + "</h1>");
		out.println("<p>Your email is: " + email + "</p>");
		out.println("</body>");
		out.println("</html>");

	}
}
