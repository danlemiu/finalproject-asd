package application;

import com.FinalProject.*;
import com.custom.aop.EventListener;
import com.custom.aop.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class MyTransactionService implements IMyTransactionService {


    @Scheduled(fixedRate=5000)
    public void welcome() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }


}
