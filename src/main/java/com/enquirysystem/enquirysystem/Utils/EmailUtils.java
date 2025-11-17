package com.enquirysystem.enquirysystem.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public boolean sendMail(String to, String subject, String body) {
		boolean isSent = false;
		
		try {
			
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			javaMailSender.send(mimeMsg);
			
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
}
