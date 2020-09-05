package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.Repository.impl.DonorRepositoryImpl;
import com.foodparcel.entity.Donation;
import com.foodparcel.entity.Donor;
import com.foodparcel.factory.DonationFactory;
import com.foodparcel.factory.DonorFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonorServiceImplTest {

    private static DonorRepository donorRepository = DonorRepositoryImpl.getDonorRepository();
    private static Donor donor = DonorFactory.createDonor("Name", "testSurname",
            "testEmail", "testPhoneNumber");

    @Test
    public void a_create() {
        Donor created = donorRepository.create(donor);
        Assert.assertEquals(donor.getId(), created.getId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Donor read = donorRepository.read(donor.getId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Donor updated = new Donor.Builder().copy(donor).setFirstName("testName")
                .setSurname("testSurname").setEmail("testEmail").setPhoneNumber("072419375")
                .build();
        updated = donorRepository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        donorRepository.delete(donor.getId());
        Assert.assertEquals(donor.getId(), donor.getId());
        System.out.println("Deleted");
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + donorRepository.getAll());
    }

}