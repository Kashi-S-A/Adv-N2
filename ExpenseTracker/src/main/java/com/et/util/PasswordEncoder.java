package com.et.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

	public String encodePassword(String password) {

		byte[] bytes = password.getBytes();

		return Base64.getEncoder().encodeToString(bytes);
	}
}
