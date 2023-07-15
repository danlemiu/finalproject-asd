package com.FinalProject;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("production")
public class TransactionDAO implements ITransactionDAO{
    private Map<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();

    public void save(Transaction transaction){
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
