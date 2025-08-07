package com.et.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handlException(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("fdgasfuidjlk");
		return "error.jsp";
	}

}
