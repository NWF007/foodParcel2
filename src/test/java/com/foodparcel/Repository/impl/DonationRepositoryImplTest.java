/* package com.foodparcel.Repository.impl;
Yusrah Soeker
 * 218150768

import com.foodparcel.Repository.DonationRepository;
import com.foodparcel.entity.Donation;
import com.foodparcel.factory.DonationFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonationRepositoryImplTest {

    @Autowired
    private static DonationRepository donationRepository;
    private static Donation donation = DonationFactory.createDonation("testDate", 100);

    @Test
    public void a_create() {
        Donation created = donationRepository.create(donation);
        Assert.assertEquals(donation.getDonationId(), created.getDonationId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Donation read = donationRepository.read(donation.getDonationId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Donation updated = new Donation.Builder().copy(donation).setDonationDate("testDate")
                .setDonateAmount(125).build();
        updated = donationRepository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        donationRepository.delete(donation.getDonationId());
        Assert.assertEquals(donation.getDonationId(), donation.getDonationId());
        System.out.println("Deleted");
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + donationRepository.getAll());
    }
}
 */
