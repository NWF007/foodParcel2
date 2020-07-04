package com.foodparcel.factory;

import com.foodparcel.entity.Donation;

public class DonationFactory {
    public static Donation createDonation(String donationId, String donationDate, double donateAmount) {
        Donation donation = new Donation.Builder()
                .setDonationId(donationId)
                .setDonationDate(donationDate)
                .setDonateAmount(donateAmount)
                .build();
        return donation;
    }
}
