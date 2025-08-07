package com.et.service;

import com.et.entity.User;

public interface UserService {

	boolean registerUser(User user);

	boolean login(String username, String password);

	User findByUsername(String username);

}
