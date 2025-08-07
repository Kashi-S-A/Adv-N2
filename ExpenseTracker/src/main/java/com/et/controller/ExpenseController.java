package com.et.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.et.entity.Expense;
import com.et.entity.User;
import com.et.service.ExpenseService;
import com.et.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
		return "login.jsp";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("user", new User());

		return "register.jsp";
	}

	@GetMapping("/addExpense")
	public String addExpensePage(Model model) {

		model.addAttribute("expense", new Expense());

		return "addExpense.jsp";
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
			HttpSession session = request.getSession(true);
			session.setAttribute("un", username);
		} else {
			mv.setViewName("login.jsp");
			mv.addObject("errmsg", "Invalid credentials");
		}

		return mv;
	}

	@PostMapping("/addExpense")
	public String addExpense(Expense expense, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("un");

		User user = userService.findByUsername(username);
		expense.setUser(user);

		String msg = expenseService.addExpense(expense);
		model.addAttribute("succmsg", msg);

		return "welcome.jsp";
	}

	@GetMapping("/expenseList")
	public String getMethodName(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("un");

		User user = userService.findByUsername(username);

		model.addAttribute("exps", user.getExpenses());

		return "expenseList.jsp";
	}

	@GetMapping("/filter")
	public String filter(HttpServletRequest request,Model model) {
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("un");

		User user = userService.findByUsername(username);

		List<Expense> expenses = expenseService.filter(user, fromDate, toDate);
		
		model.addAttribute("exps", expenses);
		model.addAttribute("from", fromDate);
		model.addAttribute("to",toDate);

		return "expenseList.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		session.invalidate();

		return "login.jsp";
	}

}
