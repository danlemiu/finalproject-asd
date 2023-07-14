package com.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService{

    ITransactionDAO transactionDAO;
    ICategoryDAO categoryDAO;

    @Autowired
    public void setTransactionDAO(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Autowired
    public TransactionService(ICategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }


    public void addTransaction(int id, String name, double amount, Category category){
        categoryDAO.save(category);
        transactionDAO.save(new Transaction(id, name, amount, category));
    }

    public Transaction getTransaction(int id){
        return transactionDAO.find(id);
    }

    public void removeTransaction(int id){
        transactionDAO.remove(id);
    }
}
