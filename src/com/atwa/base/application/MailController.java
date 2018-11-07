package com.atwa.base.application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;

@RestController("api/mail")
public class MailController {

	private static Logger log = LoggerFactory.getLogger(MailController.class);

	@Autowired
	private EmailService emailService;

	@GetMapping
	public String getWelcome() {
		return "welcome";
	}

	@PostMapping
	public String sendMail(@RequestBody Mail mail) throws MessagingException, IOException, TemplateException {
		log.info("Sending Email with Freemarker HTML Template Example");

//		mail.setFrom("salahatwa2025");
//		mail.setTo("ssatwa@Alinmaa.com");
//		mail.setSubject("Sending Email with Freemarker HTML Template Example");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Memorynotfound.com");
		model.put("location", "Belgium");
		model.put("signature", "http://memorynotfound.com");
		mail.setModel(model);

	    emailService.sendSimpleMessage(mail);

		return "success";
	}
}
