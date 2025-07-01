package com.ty.sr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-c")
public class PageC extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageC: doGet() called");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Page C</h1>");
		out.println("<p>This is Page C.</p>");
		out.println("</body></html>");
		
		resp.sendRedirect("https://www.wikipedia.org/");//url of servlet/html/jsp/third party service
	}

}
