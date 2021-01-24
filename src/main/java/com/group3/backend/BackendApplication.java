package com.group3.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		ApplicationContext aContext = SpringApplication.run(BackendApplication.class, args);

//		EmailService mailService = (EmailService) aContext.getBean("emailServiceImpl");
//		mailService.sendMail("pmarshall.dev@gmail.com", "test", "test");
	}

}
