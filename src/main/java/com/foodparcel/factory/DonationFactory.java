package com.foodparcel.factory;
/**
 * Author: Yusrah Soeker
 * Student number: 218150768
 * */
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

