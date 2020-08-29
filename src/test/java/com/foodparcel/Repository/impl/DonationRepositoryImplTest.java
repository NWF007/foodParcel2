package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.DonationRepository;
import com.foodparcel.entity.Donation;
import com.foodparcel.factory.DonationFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonationRepositoryImplTest {

    private static DonationRepository repository = DonationRepositoryImpl.getRepository();
    private static Donation donation = DonationFactory.createDonation("testDate", 100);
    @Test
    public void getRepository() {
    }

    @Test
    public void a_create() {
        Donation created = repository.create(donation);
        Assert.assertEquals(donation.getDonationId(), created.getDonationId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Donation read = repository.read(donation.getDonationId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Donation updated = new Donation.Builder().copy(donation).setDonationDate("testDate").setDonateAmount(100).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(donation.getDonationId());
        Assert.assertTrue(deleted);
        System.out.println("Deleted");
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }
}