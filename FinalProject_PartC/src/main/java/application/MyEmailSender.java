package application;

import com.FinalProject.IEmailSender;
import com.FinalProject.NewTransactionEvent;
import com.custom.aop.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;


@Service
public class MyEmailSender implements IMyEmailSender {
    @Value("smtpserver")
    private String smtpServer;

    public void sendEmail() {
        System.out.println("Sending email using smtp server " + smtpServer);
    }

}