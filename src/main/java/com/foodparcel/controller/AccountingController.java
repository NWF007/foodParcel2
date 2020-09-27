package com.foodparcel.controller;

import com.foodparcel.Service.impl.AccountingServiceImpl;
import com.foodparcel.entity.Accounting;
import com.foodparcel.factory.AccountingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingController.java
 * Submission 9
 * Date: 21 September 2020
 */

@RestController
@RequestMapping("/accounting")
public class AccountingController {

    @Autowired
    private AccountingServiceImpl accountingService;

    @PostMapping("/create")
    public Accounting create(@RequestBody Accounting accounting){
        Accounting newAccount = AccountingFactory.createAccounting(accounting.getIncome(), accounting.getExpense(),
                accounting.getBudget(), accounting.getIncomeTransactionId(), accounting.getExpenseTransactionId());
        return  accountingService.create(newAccount);
        //return accountingService.create(accounting);
    }

    @GetMapping(path = "/read/{id}")
    public Accounting read(@PathVariable String id){
        //Accounting accounting = accountingService.read(id);
        return accountingService.read(id);
    }

    //@PutMapping("/update")
    @PostMapping("/update")
    public Accounting update(@RequestBody Accounting accounting){
        return accountingService.update(accounting);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        accountingService.delete(id);
    }


    @GetMapping("/all")
    public Set<Accounting> getAll(){
        return accountingService.getAll();
    }

    @GetMapping("/profits")
    public Set<Accounting> getAllProfits(){
        return accountingService.getAllProfits();
    }
}
