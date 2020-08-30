<<<<<<< HEAD
package com.foodparcel.factory;

import com.foodparcel.entity.Donation;
import org.junit.Assert;
import org.junit.Test;

public class DonationFactoryTest {

    @Test
    public void createDonation() {
        Donation donation = DonationFactory.createDonation( "testDate", 100);
        Assert.assertEquals("testDate", donation.getDonationDate());
    }
=======
package com.foodparcel.factory;

import com.foodparcel.entity.Donation;
import org.junit.Assert;
import org.junit.Test;

public class DonationFactoryTest {

    @Test
    public void createDonation() {
        Donation donation = DonationFactory.createDonation( "testDate", 100);
        Assert.assertEquals("testDate", donation.getDonationDate());
    }
>>>>>>> fa981789147286f0246885eb07d61397839685d1
}