package com.FinalProject;

import com.custom.aop.CustomService;

@CustomService
public class TestService {

	public void testMessage(String message) {
		System.out.println("Send message from test service " + message);
	}
}
