package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.impl.AccountingRepositoryImpl;
import com.foodparcel.entity.Accounting;
import com.foodparcel.factory.AccountingFactory;
import com.foodparcel.Repository.AccountingRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingRepositoryImplTest {
    private static AccountingRepository repository = AccountingRepositoryImpl.getAccountingRepository();
    private static Accounting accounting = AccountingFactory.createAccounting(13467.89,
            21937.32, 20000.00, 12321, 8273);

    @Test
    public void a_create() {
        Accounting created = repository.create(accounting);
        assertEquals(accounting.getStatementId(), created.getStatementId());
        System.out.println("Created: " + created);
        //Integer.toHexString(System.identityHashCode(created));
    }

    @Test
    public void b_read() {
        Accounting read = repository.read(accounting.getStatementId());
        assertEquals(accounting.getStatementId(), read.getStatementId());
        System.out.println("Read: " + read);
        //Integer.toHexString(System.identityHashCode(read));
    }

    @Test
    public void c_update() {
        Accounting updated = new Accounting.Builder().copy(accounting).setIncome(31467.89).build();
        updated = repository.update(updated);
        assertEquals(accounting.getStatementId(), updated.getStatementId());
        assertNotEquals(accounting.getIncome(), updated.getIncome());
        System.out.println("Updated: " + updated);
        //Integer.toHexString(System.identityHashCode(updated));
    }

    @Test
    public void e_delete() {
        repository.delete(accounting.getStatementId());
        Accounting gone = repository.read(accounting.getStatementId());
        assertNull(gone);
        System.out.println("Deleted!");
    }

    @Test
    public void d_getAll() {
        Set<Accounting> accountings = repository.getAll();
        assertEquals(1, accountings.size());
        System.out.println("Get all: " + repository.getAll());
        //Integer.toHexString(System.identityHashCode(repository.getAll()));
    }
}