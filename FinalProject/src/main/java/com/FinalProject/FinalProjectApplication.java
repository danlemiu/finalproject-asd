package com.FinalProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.custom.aop.FWContext;

@SpringBootApplication
@ComponentScan("com.FinalProject, com.custom.aop")
public class FinalProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FinalProjectApplication.class, args);
		//System.out.println("test 3");
		FWContext fwContext = new FWContext();
		fwContext.start();
	}

}
