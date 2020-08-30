package com.foodparcel.Repository;

import com.foodparcel.entity.Accounting;

import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingRepository.java
 * Submission 7
 * Date: 30 August 2020
 */

public interface AccountingRepository extends IRepository<Accounting, String> {
    Set<Accounting> getAll();
}
