package com.custom.aop;

import java.lang.reflect.Method;

import org.springframework.util.StopWatch;

@CustomAspect
public class TestAspect {

	@After(pointcut="TestService.testMessage")
	public void sendMessage(String message) {
		System.out.println("Aspect After Send message via Test Service: " + message);
	}
	
	@Before(pointcut="TestService.testMessage")
	public void sendMessageBefore(String message) {
		System.out.println("Aspect Before Send message via Test Service: " + message);
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
