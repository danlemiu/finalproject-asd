package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.FinalProject.ITransactionService;
import com.FinalProject.Application.FWApplication;

@Configuration
@ComponentScan("application")
public class Application implements Runnable {

	@Autowired
	IMyTransactionService myTransactionService;
	
	@Autowired
	ITransactionService transactionService;
	
	public static void main(String[] args) {
		FWApplication.run(Application.class, args);
	}

	@Override
	public void run() {
		System.out.println("Application started!");
		myTransactionService.addTransaction();
		
	}

}
