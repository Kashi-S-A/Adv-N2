package com.sb.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);

		System.out.println("mail sent");
	}

	@Autowired
	private TemplateEngine engine;

	public void sendMailWithTemplate(String toEmail, String subject, String name) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);// true to send attachements

		Context context = new Context();
		context.setVariable("username", name);

		String body = engine.process("welcome-page", context);

		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body, true);// body contains html code ==> true

		helper.addAttachment("expense", new File("C:\\Users\\asus\\Downloads\\Expense Tracker.pdf"));

		javaMailSender.send(message);

		System.out.println("sent");
	}
}
