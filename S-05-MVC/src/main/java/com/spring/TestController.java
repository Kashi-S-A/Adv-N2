package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	@RequestMapping("/test")
	// @ResponseBody //return data instead view.
	public String getMessage() {
		System.out.println("method triggered");
		return "hello.html";
	}

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public ModelAndView readData(HttpServletRequest request) {
		System.out.println("this is readData");

		String un = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		String email = request.getParameter("uemail");

		System.out.println(un);
		System.out.println(pwd);
		System.out.println(email);
		
		ModelAndView mv = new ModelAndView("disp.jsp");
		mv.addObject("name", un);
		mv.addObject("email", email);
		
		return mv;
	}

	@RequestMapping("/pass")
	public String passData(Model model) {
		System.out.println("This is passData method");

		model.addAttribute("un", "Dinga");
		model.addAttribute("age", 35);

		return "pass.jsp";
	}

	@RequestMapping("/send")
	public ModelAndView sendData() {
		System.out.println("This is sendData method");

		ModelAndView mv = new ModelAndView("send.jsp");
//		mv.setViewName("send.jsp");

		mv.addObject("phone", 123456789);
		mv.addObject("address", "Thane");
		
		mv.addObject("product", new Product(101, "Samsung Phone", 69999));

		return mv;
	}

}
