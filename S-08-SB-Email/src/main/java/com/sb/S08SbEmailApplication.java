package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class S08SbEmailApplication {

	public static void main(String[] args) throws MessagingException {
		ConfigurableApplicationContext run = SpringApplication.run(S08SbEmailApplication.class, args);
	
		EmailService service = run.getBean(EmailService.class);
		
		String toEmail = "tawadeshubham10@gmail.com";
		String subject = "Registeration to Demo App";
		String body = "Hi Dear Shubham, "
				+ "Thank you for registering to our app"
				+ "we would like you to explore the services we provide throug app"
				+ "contact : 876543456"
				+ "email : xzy@gmail.com"
				+ "note : don't reply to this email";
		
//		service.sendEmail(toEmail, subject, body);
		
		String username = "Shubham";
		
		service.sendMailWithTemplate(toEmail, subject, username);
	}

}
