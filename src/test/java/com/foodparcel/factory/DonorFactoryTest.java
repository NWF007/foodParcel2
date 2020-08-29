package com.foodparcel.factory;

import com.foodparcel.entity.Donor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DonorFactoryTest {

    @Test
    public void createDonor() {
        Donor donor = DonorFactory.createDonor("testName", "testSurname", "testEmail",
                 "testPhoneNumber");
        Assert.assertEquals("testName", donor.getFirstName());
    }
}