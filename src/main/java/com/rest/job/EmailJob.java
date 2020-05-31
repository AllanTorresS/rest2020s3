package com.rest.job;


import com.rest.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableScheduling
public class EmailJob {

    @Autowired
    public EmailService emailService;

//    @Scheduled(fixedDelay = 5000)
    public void sendEmail(){
        this.emailService.sendSimpleMessage("arce", Arrays.asList("allanflfsi@gmail.com","allanfic@hotmail.com"),"teste com job normal","oi job");
    }


}
