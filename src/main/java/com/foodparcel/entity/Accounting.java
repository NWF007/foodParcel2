package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Amy Johnston (218188773)
 * Accounting.java
 * Assignment 5
 * Edited: 25 October 2020
 */
@Entity
public class Accounting {  //implements Serializable{
    @Id
    private String statementId;
    private double income;
    private double expense;
    private double budget;
    private int incomeTransactionId;
    private int expenseTransactionId;

    protected Accounting(){
    }

    private Accounting(Builder builder){
        this.statementId = builder.statementId;
        this.income = builder.income;
        this.expense = builder.expense;
        this.budget = builder.budget;
        this.incomeTransactionId = builder.incomeTransactionId;
        this.expenseTransactionId = builder.expenseTransactionId;
    }

    public String getStatementId() {
        return statementId;
    }

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
        return "Builder{" +
                " statementId=" + statementId +
                ", income=" + income +
                ", expense=" + expense +
                ", budget=" + budget +
                ", incomeTransactionId=" + incomeTransactionId +
                ", expenseTransactionId=" + expenseTransactionId +
                '}';
    }

    public static class Builder{
        private double income, expense, budget;
        private int incomeTransactionId, expenseTransactionId;
        private String statementId;

        public Builder setStatementId(String statementId){
            this.statementId = statementId;
            return this;
        }

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
            this.statementId = accounting.statementId;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return statementId.equals(builder.statementId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(statementId);
        }
    }
}
