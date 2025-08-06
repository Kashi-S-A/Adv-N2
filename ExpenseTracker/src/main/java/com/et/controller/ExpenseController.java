package com.et.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.et.entity.User;
import com.et.service.ExpenseService;
import com.et.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ExpenseController {

	private UserService userService;

	private ExpenseService expenseService;

	public ExpenseController(UserService userService, ExpenseService expenseService) {
		this.userService = userService;
		this.expenseService = expenseService;
	}

	@GetMapping("/")
	public String loginPage() {
		System.out.println("login page");
		return "login.jsp";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("user", new User());

		return "register.jsp";
	}

	@PostMapping("/register")
	public String registerUser(User user, Model model) {

		boolean registered = userService.registerUser(user);

		if (registered) {
			// registered succ
			model.addAttribute("succmsg", "Register Successfuly");
		} else {
			// already registered
			model.addAttribute("errmsg", "Already Register");
		}

		return "login.jsp";
	}

	@PostMapping("/login")
	public ModelAndView loginUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isValid = userService.login(username, password);

		ModelAndView mv = new ModelAndView();

		if (isValid) {
			mv.setViewName("welcome.jsp");
		} else {
			mv.setViewName("login.jsp");
			mv.addObject("errmsg", "Invalid credentials");
		}

		return mv;
	}

}
