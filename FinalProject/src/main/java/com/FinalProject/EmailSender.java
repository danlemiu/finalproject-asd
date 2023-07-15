package com.FinalProject;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSender implements IEmailSender {
    @Value("${smtpserver}")
    private String smtpServer;
    public void sendEmail() {
        System.out.println("Sending email using smtp server " + smtpServer);
    }
}
