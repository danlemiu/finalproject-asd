package application;

import com.FinalProject.Transaction;

public class MyNewTransactionEvent {
    private Transaction transaction;

    public MyNewTransactionEvent(Transaction transaction) {
        super();
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void getTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
