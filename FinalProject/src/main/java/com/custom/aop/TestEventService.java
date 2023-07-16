package com.custom.aop;

import com.FinalProject.NewTransactionEvent;

@EventService
public class TestEventService {
	@EventListener
	public void receiveMessage(NewTransactionEvent event) {
		System.out.println("Receive Transaction event: " + event.getTransaction().getName());
	}
}
