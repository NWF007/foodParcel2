package com.foodparcel.Service.impl;

import com.foodparcel.Repository.AccountingRepository;
import com.foodparcel.Repository.impl.AccountingRepositoryImpl;
import com.foodparcel.Service.AccountingService;
import com.foodparcel.entity.Accounting;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingServiceImpl.java
 * Submission 8
 * Date: 1 September 2020
 */

public class AccountingServiceImpl implements AccountingService {

    private static AccountingService accountingService = null;
    private AccountingRepository accountingRepository;

    private AccountingServiceImpl(){
        this.accountingRepository = AccountingRepositoryImpl.getAccountingRepository();

    }

    public static AccountingService getAccountingService(){
        if (accountingService == null) accountingService = new AccountingServiceImpl();
        return accountingService;
    }

    @Override
    public Set<Accounting> getAll() {
        return this.accountingRepository.getAll();
    }

    //unique business logic as per Accounting -> when we make a Profit
    //implementing it here is currently not expensive as we only have a few records (not like a million in the database)
    //must add this to the repository if it becomes expensive
    @Override
    public Set<Accounting> getAllProfits() {
        Set<Accounting> account = getAll();
        Set<Accounting> profit = new HashSet<>();
        for(Accounting accounting : account){
            if(accounting.getIncome() > accounting.getExpense()){
                profit.add(accounting);
            }
        }
        return profit;
    }

    @Override
    public Accounting create(Accounting accounting) {
        return this.accountingRepository.create(accounting);
    }

    @Override
    public Accounting read(String s) {
        return this.accountingRepository.read(s);
    }

    @Override
    public Accounting update(Accounting accounting) {
        return this.accountingRepository.update(accounting);
    }

    @Override
    public void delete(String s) {
        this.accountingRepository.delete(s);
    }
}
