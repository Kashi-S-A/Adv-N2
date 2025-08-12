package com.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.User;
import com.hotel.repo.UserRepo;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserRepo userRepo;

	public AuthController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		if (userRepo.findByUsername(user.getUsername()).isPresent())
			return ResponseEntity.internalServerError().body(user.getUsername() + " already registered");
		userRepo.save(user);
		return ResponseEntity.created(null).body("User Registered with username : " + user.getUsername());
	}

}
