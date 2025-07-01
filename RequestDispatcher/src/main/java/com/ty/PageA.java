package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-a")
public class PageA extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageA: doGet() called");

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head><title>Page A</title></head>");
		pw.println("<body>");
		pw.println("<h1>Welcome to Page A</h1>");
		pw.println("</body>");
		pw.println("</html>");

		String email = "dinga@gmail.com";
		Integer age = 25;

		req.setAttribute("userName", "Dinga");// Setting an attribute in the request scope
		req.setAttribute("userEmail", email); // Setting another attribute
		req.setAttribute("userAge", age); // Setting another attribute

		Employee emp = new Employee("Dingi", "dingi@gmail.com", 50000.0);
		
		req.setAttribute("employee", emp); // Setting an Employee object as an attribute
		
		RequestDispatcher rd = req.getRequestDispatcher("page-b");// page-b ==> this url of servlet PageB
		rd.forward(req, resp); // login.jsp ==> this is the jsp page
								// register.html ==> this is the html page
	}
}
