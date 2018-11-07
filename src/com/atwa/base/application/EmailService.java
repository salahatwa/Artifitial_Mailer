package com.atwa.base.application;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	private Logger log=LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSenderImpl emailSender;

	@Autowired
	private Configuration freemarkerConfig;

	public void sendSimpleMessage(Mail mail) throws MessagingException, IOException, TemplateException {

		emailSender.setUsername(mail.getUsername());
		emailSender.setPassword(mail.getFrom());

		
	
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));

		Template t = freemarkerConfig.getTemplate("email-template.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

		helper.setTo(mail.getTo());
		helper.setText(html, true);
		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());

		System.out.println(html);
		
		
		log.info(emailSender.getHost()+" , "+ emailSender.getUsername());

//        emailSender.send(message);
	}

}
