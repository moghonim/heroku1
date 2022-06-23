package com.stackdeans.loginregister.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String mail) throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        //yo some one mail
        mimeMessageHelper.setTo(mail);
        mimeMessageHelper.setSubject("testing sending mail API");
        mimeMessageHelper.setText("<h2>check that<h2>", true);
        mimeMessageHelper.addAttachment("img.png", new ClassPathResource("img.png"));

        javaMailSender.send(msg);
    }
}
