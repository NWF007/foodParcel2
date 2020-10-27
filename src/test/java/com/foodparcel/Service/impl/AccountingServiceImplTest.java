//package com.foodparcel.Service.impl;
//
//import com.foodparcel.Service.AccountingService;
//import com.foodparcel.entity.Accounting;
//import com.foodparcel.factory.AccountingFactory;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
///**
// * Author: Amy Johnston (218188773)
// * AccountingServiceImplTest.java
// * Submission 8
// * Date: 1 September 2020
// * Edited: 26 October 2020
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AccountingServiceImplTest {
//    @Autowired
//    private static AccountingService accountingService;
//    private static Accounting accounting = AccountingFactory.createAccounting(13467.89,
//            21937.32, 20000.00, 12321, 8273);
//
//    @Test
//    public void a_create() {
//        Accounting created = accountingService.create(accounting);
//        assertEquals(accounting.getStatementId(), created.getStatementId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Accounting read = accountingService.read(accounting.getStatementId());
//        assertEquals(accounting.getStatementId(), read.getStatementId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void d_update() {
//        Accounting updated = new Accounting.Builder().copy(accounting).setExpense(12937.32).build();
//        updated = accountingService.update(updated);
//        assertEquals(accounting.getStatementId(), updated.getStatementId());
//        assertNotEquals(accounting.getExpense(), updated.getExpense());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void g_delete() {
//        accountingService.delete(accounting.getStatementId());
//        Accounting gone = accountingService.read(accounting.getStatementId());
//        assertNull(gone);
//        System.out.println("Deleted!");
//    }
//
//    @Test
//    public void e_getAll() {
//        Set<Accounting> accountings = accountingService.getAll();
//        assertEquals(1, accountings.size());
//        assertNotNull(accountings);
//        System.out.println("Get all: " + accountingService.getAll());
//    }
//
//    //Demonstrating Business Logic when it is not met
//    // -> this will display nothing as at this point we are making a Loss not a Profit
//    @Test
//    public void c_getAllProfits() {
//        System.out.println("Profit(s): " + accountingService.getAllProfits());
//    }
//
//    //Demonstrating Business Logic when it is met
//    // -> this will display the now updated stuff as we are making a Profit since our expense was changed
//    @Test
//    public void f_getAllProfits() {
//        System.out.println("Profit(s): " + accountingService.getAllProfits());
//    }
//}
