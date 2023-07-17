package application;

import com.custom.aop.CustomService;

@CustomService
public class AOPService implements IAOPService {

	@Override
	public void sendMessage() {
		System.out.println("Send message from AOP Service");
	}
}
