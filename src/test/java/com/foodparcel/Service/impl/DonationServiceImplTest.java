package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Service.DonationService;
import com.foodparcel.entity.Donation;
import com.foodparcel.factory.DonationFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonationServiceImplTest {

    private static DonationService donationService = DonationServiceImpl.getDonationService();
    private static Donation donation = DonationFactory.createDonation("testDate", 100);

    @Test
    public void a_create() {
        Donation created = donationService.create(donation);
        assertEquals(donation.getDonationId(), created.getDonationId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Donation read = donationService.read(donation.getDonationId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Donation updated = new Donation.Builder().copy(donation).setDonationDate("testDate")
                .setDonateAmount(125).build();
        updated = donationService.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        donationService.delete(donation.getDonationId());
        assertEquals(donation.getDonationId(), donation.getDonationId());
        System.out.println("Deleted");
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + donationService.getAll());
    }

}