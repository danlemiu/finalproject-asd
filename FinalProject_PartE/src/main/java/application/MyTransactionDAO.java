package application;

import com.FinalProject.ITransactionDAO;
import com.FinalProject.Transaction;
import com.custom.aop.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("Production")
public class MyTransactionDAO implements IMyTransactionDAO {
    private Map<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();

    public void save(Transaction transaction){
        System.out.println("Add new Transaction: " + transaction.getName() + " - Amount: " + transaction.getAmount() );
        transactions.put(transaction.getId(), transaction);
    }

    public Transaction find(int id){
        System.out.println("Transaction production");
        return transactions.get(id);
    }

    public void remove(int id){
        transactions.remove(id);
    }
}
