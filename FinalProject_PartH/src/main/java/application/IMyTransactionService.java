package application;

import com.FinalProject.NewTransactionEvent;

public interface IMyTransactionService {
    public void addTransaction();
    public void receiveMessage(NewTransactionEvent event);
}
