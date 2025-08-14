package com.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.LoginDTO;
import com.hotel.entity.User;
import com.hotel.repo.UserRepo;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserRepo userRepo;

	private final BCryptPasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthController(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		if (userRepo.findByUsername(user.getUsername()).isPresent())
			return ResponseEntity.badRequest().body(user.getUsername() + " already registered");

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepo.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered with username : " + user.getUsername());
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.getUsername(),
				dto.getPassword());

//		Authentication authentication = authenticationManager.authenticate(authToken);
//
//		if (authentication.isAuthenticated()) {
//			return ResponseEntity.ok("Logged In");
//		}
//
//		return ResponseEntity.badRequest().body("Invalid credentials");
		
		authenticationManager.authenticate(authToken);

		return ResponseEntity.ok("Logged In");
	}

}
