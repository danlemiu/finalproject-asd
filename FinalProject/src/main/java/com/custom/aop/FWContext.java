package com.custom.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;


public class FWContext {

	private static List<Object> serviceObjectMap = new ArrayList<>();
	private static List<Object>	aspectObjectMap = new ArrayList<>();
	public FWContext() {
		try {			
			Reflections reflections = new Reflections("");
			
			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> servicetypes = reflections.getTypesAnnotatedWith(CustomService.class);
			for (Class<?> serviceClass : servicetypes) {
				serviceObjectMap.add((Object) serviceClass.newInstance());
			}
			
			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> aspecttypes = reflections.getTypesAnnotatedWith(CustomAspect.class);
			for (Class<?> aspectClass : aspecttypes) {
				aspectObjectMap.add((Object) aspectClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private void performDI() {
//		try {
//			for (Object theServiceClass : serviceObjectMap) {
//		         // find annotated fields
//				 for (Field field : theTestClass.getClass().getDeclaredFields()) {
//			            if (field.isAnnotationPresent(Inject.class)) {
//			                // get the type of the field
//			            	Class<?> theFieldType =field.getType();
//			            	//get the object instance of this type
//			            	Object instance = getServiceBeanOftype(theFieldType);
//			            	//do the injection
//			            	field.setAccessible(true);
//			            	field.set(theTestClass, instance);
//			            }
//			        }
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void start() {
		try {
			for(Object serviceClass: serviceObjectMap) {
				for (Method method : serviceClass.getClass().getDeclaredMethods()) {
					Object theTestClass = findAspectClass(method);
					//find the @Before method
					if(theTestClass == null) break;
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(Before.class)) {
							methodAspect.invoke(theTestClass, "Test");
						}
					}
					//find the @Around method
					boolean isAround = false;
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(Around.class)) {
							methodAspect.invoke(theTestClass, method, serviceClass, new Object[]{"Test"});
							isAround = true;
						}
					}
					//invoke service method
					if(!isAround) {
						method.invoke(serviceClass, "Test");
					}
					
					//find the @After method
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(After.class)) {
							methodAspect.invoke(theTestClass, "Test");
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object findAspectClass(Method serviceMethod) {
		for (Object theTestClass : aspectObjectMap) {
			for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
				if (methodAspect.getAnnotations()[0].toString().indexOf(serviceMethod.getName()) >= 0) {
					return theTestClass;
				}
			}
		}
		return null;
	}
}
