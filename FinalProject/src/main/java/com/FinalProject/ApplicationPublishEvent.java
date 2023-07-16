package com.FinalProject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import com.custom.aop.EventListener;
import com.custom.aop.EventService;

@Service
public class ApplicationPublishEvent implements IApplicationEventPublisher {

	@Override
	public void publishEvent(NewTransactionEvent event) {
		Reflections reflections = new Reflections("");
		// find and instantiate all classes annotated with the @Service annotation
		Set<Class<?>> servicetypes = reflections.getTypesAnnotatedWith(EventService.class);
		 // find all methods annotated with the @Test annotation
		
		for(Class<?> clazz: servicetypes) {
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.isAnnotationPresent(EventListener.class)) {
					for(Class<?> clazzType: method.getParameterTypes()) {
						Object instance;
						try {
							instance = (Object)clazz.newInstance();
							method.invoke(instance, event);
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			}
		}
		
	}

}
