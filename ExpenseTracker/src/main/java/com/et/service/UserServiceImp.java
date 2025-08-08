package com.et.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.entity.User;
import com.et.repository.UserRepository;
import com.et.util.EmailService;
import com.et.util.PasswordEncoder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

	@Autowired
	private EmailService emailService;

	@Override
	public String forgotPwd(HttpServletRequest request, String emailusername) throws Exception {
		Optional<User> opt = userRepository.findByUsernameOrEmail(emailusername, emailusername);
		if (opt.isPresent()) {
			// send reset link to mail and return succ msg

			String otp = UUID.randomUUID().toString();
			System.out.println("otp : " + otp);
			HttpSession session = request.getSession(false);
			session.setAttribute("otp", otp);

			emailService.sendMailWithTemplate(opt.get().getEmail(), otp);
			return "please check you registered email";
		} else {
			// return error message
			return "enter registered email/username";
		}
	}

	@Override
	public String resetPassword(String username, String newPwd) {
		User user = userRepository.findByUsernameOrEmail(username, "").get();
		user.setPassword(passwordEncoder.encodePassword(newPwd));
		userRepository.save(user);
		return "New Password Updated";
	}

}
