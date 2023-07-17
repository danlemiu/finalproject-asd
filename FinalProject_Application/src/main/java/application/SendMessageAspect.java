package application;

import java.lang.reflect.Method;

import org.springframework.util.StopWatch;

import com.custom.aop.After;
import com.custom.aop.Around;
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
	
	@Around("execution (* customers..CustomerDAO*.*(..))")
	public Object invoke(Method call, Object instance, Object[] args) throws Throwable {
		StopWatch clock = new StopWatch("");
		clock.start(call.getName());
		Object object = call.invoke(instance, args);
		clock.stop();
		System.out.println(clock.prettyPrint());
		return object;
	}
}
