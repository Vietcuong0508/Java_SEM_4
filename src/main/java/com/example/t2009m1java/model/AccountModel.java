package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean save(Account account);
    boolean update(int id, Account updateAccount);
    boolean delete(int id);
    List<Account> findAll();
    Account findById(int id);
}
