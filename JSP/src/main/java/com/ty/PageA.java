package com.ty;

import java.io.IOException;

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
		System.out.println("This is PageA");

		req.setAttribute("userName", "Dinga");
		req.setAttribute("age", 35);
		
		User user=new User();
		user.setUid(101);
		user.setEmail("manga@gmail.com");
		user.setName("Manga");
		
		req.setAttribute("myUser", user);

		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, resp);
	}
}
