package application;

import com.custom.aop.After;
import com.custom.aop.Before;
import com.custom.aop.CustomAspect;

@CustomAspect
public class SendMessageAspect {

	@After(pointcut="IAOPService.sendMessage")
	public void sendMessageAfter() {
		System.out.println("Aspect After Send message via AOP Service");
	}
	
	@Before(pointcut="IAOPService.sendMessage")
	public void sendMessageBefore() {
		System.out.println("Aspect Before Send message via AOP Service");
	}
}
