package com.et.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.et.entity.User;
import com.et.repository.UserRepository;
import com.et.util.PasswordEncoder;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean registerUser(User user) {
		Optional<User> opt = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
		if (opt.isPresent()) {
			// Already register with give email or username
			return false;
		} else {
			// register successfully
			user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
			userRepository.save(user);
			return true;
		}
	}

	@Override
	public boolean login(String username, String password) {
//		String encodedPassword = passwordEncoder.encodePassword(password);
//		Optional<User> opt = userRepository.findByUsernameAndPassword(username, encodedPassword);
//
//		if (opt.isPresent()) {
//			return true;
//		} else {
//			return false;
//		}

		return userRepository.findByUsernameAndPassword(username, passwordEncoder.encodePassword(password)).isPresent();
	}

}
