package application;

import com.FinalProject.Category;
import com.FinalProject.Transaction;
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
	
	public static void main(String[] args) {
		FWApplication.run(Application.class, args);
	}

	@Override
	public void run() {
		for(int i= 0; i < 8; i++) {
			try {
				myTransactionService.addTransaction();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
