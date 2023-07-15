package com.FinalProject;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class SMSSender {
    @Async
    @EventListener
    public void onEvent(NewTransactionEvent event) {
        System.out.println("SMS Sender received new transaction event :" + event.getTransaction());
    }
}
