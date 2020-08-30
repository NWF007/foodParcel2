<<<<<<< HEAD
package com.foodparcel.factory;

import com.foodparcel.entity.Donation;
import com.foodparcel.util.IDGenerator;

public class DonationFactory {
    public static Donation createDonation(String donationDate, double donateAmount) {
        String donationId = IDGenerator.generateId();
        Donation donation = new Donation.Builder()
                .setDonationId(donationId)
                .setDonationDate(donationDate)
                .setDonateAmount(donateAmount)
                .build();
        return donation;
    }
}

=======
package com.foodparcel.factory;

import com.foodparcel.entity.Donation;
import com.foodparcel.util.IDGenerator;


public class DonationFactory {
    public static Donation createDonation(String donationDate, double donateAmount) {
        String donationId = IDGenerator.generateId();
        Donation donation = new Donation.Builder()
                .setDonationId(donationId)
                .setDonationDate(donationDate)
                .setDonateAmount(donateAmount)
                .build();
        return donation;
    }
}

>>>>>>> fa981789147286f0246885eb07d61397839685d1
