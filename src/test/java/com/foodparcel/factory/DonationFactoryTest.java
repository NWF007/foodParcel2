package com.foodparcel.factory;
/**
 * Author: Yusrah Soeker
 * Student number: 218150768
 * */
import com.foodparcel.entity.Donation;
import org.junit.Assert;
import org.junit.Test;

public class DonationFactoryTest {

    @Test
    public void createDonation() {
        Donation donation = DonationFactory.createDonation( "testDate", 100);
        Assert.assertEquals("testDate", donation.getDonationDate());
    }

}
