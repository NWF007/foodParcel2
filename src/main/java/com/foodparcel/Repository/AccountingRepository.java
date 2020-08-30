package com.foodparcel.Repository;

import com.foodparcel.entity.Accounting;

import java.util.Set;

public interface AccountingRepository extends IRepository<Accounting, String> {
    Set<Accounting> getAll();
}
