package application;

import com.FinalProject.Transaction;

public interface IMyTransactionDAO {
    public void save(Transaction transaction);

    public Transaction find(int id);

    public void remove(int id);
}
