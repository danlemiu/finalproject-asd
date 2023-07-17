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
	
	@Override
	public void addTransaction() {
		Transaction trans = new Transaction(0, "deposit", 199, new Category(0, "cat1"));
		transactionDAO.save(trans);
	}
	
}
