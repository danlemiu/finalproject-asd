package com.FinalProject.Application;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.FinalProject.ICategoryService;
import com.FinalProject.IEmailSender;
import com.FinalProject.ITransactionService;


@Configuration
@ComponentScan("com.FinalProject")
public class Application {
    @Autowired
    ITransactionService transactionService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IEmailSender emailSender;

    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(
    			Application.class);
    }
    
    public static void run(Class<?> clazz, String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
    	main(args);
    	Object intance = clazz.newInstance();
    	for (Method method : intance.getClass().getDeclaredMethods()) {
    		if("run".equals(method.getName()))
    		method.invoke(intance);
    	}
    	
    }
}

