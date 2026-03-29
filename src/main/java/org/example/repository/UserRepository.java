package org.example.repository;

import org.springframework.stereotype.Repository;

// Repository below is used for dao layer
@Repository
public class UserRepository {
    public String getUserFromDb() {
        return "got data from db";
    }
    public String getTransactionsFromDb() {
        return "got transaction data from db";
    }
}
