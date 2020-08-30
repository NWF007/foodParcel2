package com.foodparcel.entity;

/**
 * Author: Amy Johnston (218188773)
 * Accounting.java
 * Assignment 5
 */

public class Accounting {
<<<<<<< HEAD
    private String statementId;
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
    private double income;
    private double expense;
    private double budget;
    private int incomeTransactionId;
    private int expenseTransactionId;

    private Accounting(Builder builder){
<<<<<<< HEAD
        this.statementId = builder.statementId;
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
        this.income = builder.income;
        this.expense = builder.expense;
        this.budget = builder.budget;
        this.incomeTransactionId = builder.incomeTransactionId;
        this.expenseTransactionId = builder.expenseTransactionId;
    }

<<<<<<< HEAD
    public String getStatementId() {
        return statementId;
    }

=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public double getBudget() {
        return budget;
    }

    public int getIncomeTransactionId() {
        return incomeTransactionId;
    }

    public int getExpenseTransactionId() {
        return expenseTransactionId;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Builder{" +
                " statementId=" + statementId +
                ", income=" + income +
=======
        return "Accounting{" +
                "income=" + income +
>>>>>>> fa981789147286f0246885eb07d61397839685d1
                ", expense=" + expense +
                ", budget=" + budget +
                ", incomeTransactionId=" + incomeTransactionId +
                ", expenseTransactionId=" + expenseTransactionId +
                '}';
    }

    public static class Builder{
        private double income, expense, budget;
        private int incomeTransactionId, expenseTransactionId;
<<<<<<< HEAD
        private String statementId;

        public Builder setStatementId(String statementId){
            this.statementId = statementId;
            return this;
        }
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1

        public Builder setIncome(double income){
            this.income = income;
            return this;
        }

        public Builder setExpense(double expense){
            this.expense = expense;
            return this;
        }

        public Builder setBudget(double budget){
            this.budget = budget;
            return this;
        }

        public Builder setIncomeTransactionId(int incomeTransactionId){
            this.incomeTransactionId = incomeTransactionId;
            return this;
        }

        public Builder setExpenseTransactionId(int expenseTransactionId){
            this.expenseTransactionId = expenseTransactionId;
            return this;
        }

        public Builder copy(Accounting accounting){
<<<<<<< HEAD
            this.statementId = accounting.statementId;
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
            this.income = accounting.income;
            this.expense = accounting.expense;
            this.budget = accounting.budget;
            this.incomeTransactionId = accounting.incomeTransactionId;
            this.expenseTransactionId = accounting.expenseTransactionId;
            return this;
        }

        public Accounting build(){
            return new Accounting(this);
        }
    }
}
