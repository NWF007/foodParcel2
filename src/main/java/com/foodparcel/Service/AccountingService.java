package com.foodparcel.Service;

import com.foodparcel.entity.Accounting;
import java.util.Set;

/**
 * Author: Amy Johnston (218188773)
 * AccountingService.java
 * Submission 8
 * Date: 1 September 2020
 */

public interface AccountingService extends IService <Accounting, String> {
    Set<Accounting> getAll();

    //unique business logic as per Accounting
    //when we make a Profit
    Set<Accounting> getAllProfits();
}
