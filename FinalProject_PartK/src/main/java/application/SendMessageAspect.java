package application;

import java.lang.reflect.Method;

import org.springframework.util.StopWatch;

import com.custom.aop.Around;
import com.custom.aop.CustomAspect;

@CustomAspect
public class SendMessageAspect {

	@Around(pointcut="IAOPService.sendMessage")
	public Object invoke(Method call, Object instance, Object[] args) throws Throwable {
		StopWatch clock = new StopWatch("");
		clock.start(call.getName());
		Object object = call.invoke(instance, args);
		clock.stop();
		System.out.println(clock.prettyPrint());
		return object;
	}
}
