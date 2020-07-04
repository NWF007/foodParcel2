package com.foodparcel.factory;

import org.junit.Before;
import org.junit.Test;
import com.foodparcel.entity.Accounting;
import org.junit.Assert;

/**
 * Author: Amy Johnston (218188773)
 * AccountingFactoryTest.java
 * Submission 6
 * Date: 04 July 2020
 */

public class AccountingFactoryTest {

    private Accounting accounting;

    @Before
    public void setUp() throws Exception {
        accounting = AccountingFactory.createAccounting(6578.55, 5198.89, 7000.00, 10001, 56732);
    }

    @Test
    public void createAccounting() {
        Assert.assertEquals(6579.02, accounting.getIncome(), .50);//this allows a 50c difference between the expected and actual value

        /*The delta parameter refers to the maximum difference aka delta between the expected and the actual value for which both numbers are still considered equal.
        Since I am dealing with money, allowing a couple cents difference and maybe even a couple Rand is to be expected but a larger number like R500 is
        not acceptable as this could mean fraud and would need to be investigated!*/

        Assert.assertEquals(5200.19, accounting.getExpense(), 1.50);//allows R1.50 difference
    }
}