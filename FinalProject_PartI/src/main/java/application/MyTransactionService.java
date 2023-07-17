package application;

import com.FinalProject.*;
import com.custom.aop.Async;
import com.custom.aop.EventListener;
import com.custom.aop.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

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

    @Async
    @EventListener
    public void receiveMessage(NewTransactionEvent event) {
        System.out.println("Receive Transaction event: " + event.getTransaction().getName());
    }

}
