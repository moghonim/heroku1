package com.stackdeans.loginregister.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class SendMailsController {
    @Autowired
    private MailService mailService;

    @GetMapping("/send-mail")
    public String sendMailAttachment() throws MessagingException, IOException {
        String mail = "";
        mailService.sendMail(mail);
        return "mail sent succefuly";
    }
}
