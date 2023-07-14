package com.FinalProject;

import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionDAO {
    public void save(Transaction transaction);

    public Transaction find(int id);

    public void remove(int id);
}
