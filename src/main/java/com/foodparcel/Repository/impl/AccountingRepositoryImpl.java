package com.foodparcel.Repository.impl;

import com.foodparcel.entity.Accounting;
import com.foodparcel.Repository.AccountingRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingRepositoryImpl.java
 * Submission 7
 * Date: 30 August 2020
 */

public class AccountingRepositoryImpl implements AccountingRepository {
    private Set<Accounting> accountDB;
    private static AccountingRepository accountingRepository = null;

    private AccountingRepositoryImpl() {
        this.accountDB = new HashSet<>();
    }

    //Singleton
    public static AccountingRepository getAccountingRepository(){
        if(accountingRepository == null){
            accountingRepository = new AccountingRepositoryImpl();
        }
        return accountingRepository;
    }

    //create, read, update, delete
    /**
     *
     * @param accounting
     * @return
     */
    @Override
    public Accounting create(Accounting accounting){
        //Accounting account= AccountingFactory.createAccounting(statementId, income,  expense, budget, incomeTransactionId, expenseTransactionId);
        this.accountDB.add(accounting);
        return accounting;
    }

    /**
     *
     * @param statementId
     * @return
     */
    @Override
    public Accounting read(String statementId){
        Accounting accounting = null;
        for(Accounting a : this.accountDB){
            if(a.getStatementId().equalsIgnoreCase(statementId)){
                accounting = a;
                break;
            }
        }
        /*Accounting accounting = this.accountDB.stream()
                .filter(a -> a.getStatementId()
                .equalsIgnoreCase(statementId))
                .findAny()
                .orElse(null);*/
        return accounting;
    }

    /**
     *
     * @param accounting - can update budget as this is decided by the accountants
     *                 while income and expense is based on the donations and delivery
     * @return
     */
    @Override
    public Accounting update(Accounting accounting){
        //get the object
        Accounting oldAccounting = read(accounting.getStatementId());
        //and then update
        if(oldAccounting != null){
            this.accountDB.remove(oldAccounting);
            this.accountDB.add(accounting);
        }
        return accounting;
    }

    /**
     *
     * @param statementId
     */
    @Override
    public void delete(String statementId){
        Accounting accounting = read(statementId);
        if(accounting != null){
            this.accountDB.remove(accounting);
        }
    }

    @Override
    public Set<Accounting> getAll() {
        return this.accountDB;
    }
}

