package com.foodparcel.factory;

import com.foodparcel.entity.Accounting;
<<<<<<< HEAD
import com.foodparcel.util.IDGenerator;
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1

/**
 * Author: Amy Johnston (218188773)
 * AccountingFactory.java
 * Submission 6
 * Date: 6 July 2020
 */

public class AccountingFactory {
    public static Accounting createAccounting(double income, double expense, double budget, int incomeTransactionId, int expenseTransactionId) {
<<<<<<< HEAD
        //String statementId = IDGenerator.generateId();
        Accounting accounting = new Accounting.Builder()
                .setStatementId(IDGenerator.generateId())
=======
        Accounting accounting = new Accounting.Builder()
>>>>>>> fa981789147286f0246885eb07d61397839685d1
                .setIncome(income)
                .setExpense(expense)
                .setBudget(budget)
                .setIncomeTransactionId(incomeTransactionId)
                .setExpenseTransactionId(expenseTransactionId)
                .build();
        return accounting;
    }
}
