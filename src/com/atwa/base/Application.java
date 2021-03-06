package com.atwa.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atwa.base.application.EmailService;
import com.atwa.base.application.Mail;

@SpringBootApplication
public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

//    @Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("Sending Email with Freemarker HTML Template Example");

		Mail mail = new Mail();
		mail.setFrom("salahatwa2025");
		mail.setTo("ssatwa@Alinmaa.com");
		mail.setSubject("Sending Email with Freemarker HTML Template Example");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Memorynotfound.com");
		model.put("location", "Belgium");
		model.put("signature", "http://memorynotfound.com");
		mail.setModel(model);

		emailService.sendSimpleMessage(mail);
	}
}
