package com.et.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMailWithTemplate(String toEmail,String otp) throws Exception {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);// true to send attachements

//		Context context = new Context();
//		context.setVariable("email", toEmail);

//		String body = engine.process("forgot-pwd", context);
		
		// Read JSP template as plain text
	    String templatePath = "src/main/webapp/forgotPwdTemp.jsp";
	    String body = new String(Files.readAllBytes(Paths.get(templatePath)), StandardCharsets.UTF_8);

	    // Replace placeholder with actual email
	    body = body.replace("${otp}", otp);

		helper.setTo(toEmail);
		helper.setSubject("Reset Password Request");
		helper.setText(body, true);// body contains html code ==> true

		javaMailSender.send(message);

		System.out.println("sent mail to : "+toEmail);
	}
}
