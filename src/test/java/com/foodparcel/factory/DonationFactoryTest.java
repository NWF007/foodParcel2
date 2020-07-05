package com.foodparcel.factory;

import com.foodparcel.entity.Donation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DonationFactoryTest {

    @Test
    public void createDonation() {
        Donation donation = DonationFactory.createDonation("testID", "testDate", 100);
        Assert.assertEquals("testID", donation.getDonationId());
    }
}