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
	public String expenseList(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("un");

		User user = userService.findByUsername(username);

		model.addAttribute("exps", user.getExpenses());

		return "expenseList.jsp";
	}

	@GetMapping("/filter")
	public String filter(HttpServletRequest request, Model model) {
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("un");

		User user = userService.findByUsername(username);

		List<Expense> expenses = expenseService.filter(user, fromDate, toDate);

		model.addAttribute("exps", expenses);
		model.addAttribute("from", fromDate);
		model.addAttribute("to", toDate);

		return "expenseList.jsp";
	}

	@GetMapping("/editExpense")
	public String updateExpense(HttpServletRequest request, Model model) {
		Integer eid = Integer.parseInt(request.getParameter("eid"));

		Expense expense = expenseService.findById(eid);

		model.addAttribute("expense", expense);

		return "updateExpense.jsp";
	}

	@PostMapping("/updateExpense")
	public String postMethodName(Expense expense, Model model) {
		System.out.println(expense.getEid());
		System.out.println(expense.getDescription());
		System.out.println(expense.getName());
		System.out.println(expense.getAmount());
		System.out.println(expense.getUpdateDate());

		String msg = expenseService.updateExpense(expense);
		model.addAttribute("succmsg", msg);

		return "welcome.jsp";
	}

	@GetMapping("/deleteExpense")
	public String deleteExpense(HttpServletRequest request, Model model) {
		Integer eid = Integer.parseInt(request.getParameter("eid"));

		String msg = expenseService.deleteExpense(eid);

		model.addAttribute("succmsg", msg);

		return "welcome.jsp";
	}

	@PostMapping("/forgot-password")
	public String forgotPwd(HttpServletRequest request, Model model) throws Exception {
		String emailusername = request.getParameter("emailusername");

		String msg = userService.forgotPwd(request, emailusername);

		model.addAttribute("msg", msg);

		return "reset-password.jsp";
	}

	@PostMapping("/reset-password")
	public String postMethodName(HttpServletRequest request, Model model) {
//		String email = request.getParameter("email");
		String newPwd = request.getParameter("newPassword");
		String otp = request.getParameter("otp");

		HttpSession session = request.getSession(false);

		String sessionOtp = (String) session.getAttribute("otp");
		String username=(String)session.getAttribute("un");
		
		System.out.println(otp);
		System.out.println(sessionOtp);
		if (otp.equals(sessionOtp)) {
			System.out.println("changed");
			String message = userService.resetPassword(username, newPwd);

			model.addAttribute("succmsg", message);
		} else {
			System.out.println("fjhdsakjl");
			model.addAttribute("errmsg", "Incorrect otp");
		}
		return "login.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		session.invalidate();

		return "login.jsp";
	}

}
