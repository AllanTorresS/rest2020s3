package com.rest.service;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class EmailService {


    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private RequestService requestService;

    @Autowired
    private TemplateEngine templateEngine;

    @EventListener
    private void sendEmailWithThymeLeaf(ApplicationReadyEvent readyEvent){
        Context context = new Context( new Locale("pt","BR"));
        Map<String,Object> variaveisTemplate = new HashMap<>();
        variaveisTemplate.put("message","allan");
        variaveisTemplate.put("requests",requestService.listAllUser());
        String  templateDiretorio = "email";
        variaveisTemplate.entrySet().forEach(e->context.setVariable(e.getKey(),e.getValue()));

        String mensagen = templateEngine.process(templateDiretorio,context);
      this.sendSimpleMessage("arce", Arrays.asList("allanflfsi@gmail.com","allanfic@hotmail.com"),"teste normal",mensagen);
    }


    public void sendSimpleMessage(String remetente, List<String> destinatarios, String assunto, String mensagem) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"UTF-8");

        try {
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(destinatarios.toArray(new String[0]));
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(mensagem,true);

            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("problema no envio de email", e);
        }

    }
}
