package com.custom.aop;

@CustomService
public class TestService {

	public void testMessage(String message) {
		System.out.println("Send message from test service " + message);
	}
}
