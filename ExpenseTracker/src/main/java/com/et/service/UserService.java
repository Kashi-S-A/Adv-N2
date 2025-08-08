package com.et.service;

import com.et.entity.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	boolean registerUser(User user);

	boolean login(String username, String password);

	User findByUsername(String username);

	String forgotPwd(HttpServletRequest request,String emailusername) throws Exception;

	String resetPassword(String email, String newPwd);

}
