package com.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/register")
	public String register() {
		return "Register page";
	}

	@GetMapping("/admin/hi")
	public String admin() {
		return "Hi Admin!!";
	}

	@GetMapping("/user/hi")
	public String user() {
		return "Hi User!!";
	}

}
