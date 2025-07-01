package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-b")
public class PageB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageB: doGet() called");

		String recievedName = (String) req.getAttribute("userName"); // Retrieve the attribute set in PageA
		String recievedEmail = (String) req.getAttribute("userEmail"); // Retrieve the email attribute
		int recievedAge = (int) req.getAttribute("userAge"); // Retrieve the age attribute

		Employee recievedEmp = (Employee) req.getAttribute("employee"); // Retrieve the Employee object if needed

		System.out.println("Name : " + recievedName);
		System.out.println("Email : " + recievedEmail);
		System.out.println("Age : " + recievedAge);
		System.out.println(recievedEmp);

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head><title>Page B</title></head>");
		pw.println("<body>");
		pw.println("<h1>" + recievedName + ",Welcome to Page B</h1><br><h2>Your Details are as follows:</h2>");
		pw.println("<h3>Email : " + recievedEmail + "</h3>");
		pw.println("<h3>Age : " + recievedAge + "</h3><hr>");
		pw.println("<h3>Employee Details : " + recievedEmp + "</h3>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
