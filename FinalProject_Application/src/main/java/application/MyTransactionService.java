package application;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalProject.Category;
import com.FinalProject.IApplicationEventPublisher;
import com.FinalProject.ITransactionDAO;
import com.FinalProject.NewTransactionEvent;
import com.FinalProject.Transaction;
import com.custom.aop.EventListener;
import com.custom.aop.Scheduled;


@Service
public class MyTransactionService implements IMyTransactionService {

	@Autowired
	private ITransactionDAO transactionDAO;
	
	@Autowired
	private IApplicationEventPublisher publisher;
	
	@Override
	public void addTransaction() {
		Transaction trans = new Transaction(0, "deposit", 199, new Category(0, "cat1"));
		transactionDAO.save(trans);
		publisher.publishEvent(new NewTransactionEvent(trans));
	}
	
	@Scheduled(fixedRate=5000)
	public void welcome() {
		Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
	}
	
	@Scheduled(cron="1 0")
	public void welcomeCron() {
		Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This cron task runs at " + currenttime);
	}
	
	@EventListener
	public void receiveMessage(NewTransactionEvent event) {
		System.out.println("Receive Transaction event: " + event.getTransaction().getName());
	}
	
}
