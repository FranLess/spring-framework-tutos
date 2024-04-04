package com.example.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySources(@PropertySource("classpath:email.properties"))
public class MailConfig {
    @Autowired
    private Environment env;

    // Configure the mail sender
    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("email.host"));
        mailSender.setPort(Integer.valueOf(env.getProperty("email.port")));
        mailSender.setUsername(env.getProperty("email.username"));
        mailSender.setPassword(env.getProperty("email.password"));

        mailSender.setJavaMailProperties(mailSenderProperties());
        return mailSender;
    }

    // Set the properties for mail sender
    private Properties mailSenderProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "send.smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");
        return props;
    }

}
