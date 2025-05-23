package com.nhom6.mxh.Config.Mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//Cau hinh thu vien mail
@Configuration
public class MailConfig 
{
	@Autowired
	private Environment environment;
	
	//Khoi tao mail sender
	@Bean
	public JavaMailSender getMailSender()
	{
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(environment.getProperty("spring.mail.host"));
            javaMailSender.setPort(Integer.valueOf(environment.getProperty("spring.mail.port")));
            javaMailSender.setUsername(environment.getProperty("spring.mail.username"));
            javaMailSender.setPassword(environment.getProperty("spring.mail.password"));

            //du lieu cau hinh cua application.properties
            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.starttls.enable", "true");
            javaMailProperties.put("mail.smtp.auth", "true");
            javaMailProperties.put("mail.transport.protocol", "smtp");
            javaMailProperties.put("mail.debug", "true");
            javaMailProperties.put("mail.smtp.ssl.trust", "*");

            javaMailSender.setJavaMailProperties(javaMailProperties);
            return javaMailSender;
	}
}

