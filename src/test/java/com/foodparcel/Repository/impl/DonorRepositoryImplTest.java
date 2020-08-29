package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.entity.Donor;
import com.foodparcel.factory.DonorFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonorRepositoryImplTest {

        private static DonorRepository repository = DonorRepositoryImpl.getRepository();
        private static Donor donor = DonorFactory.createDonor("testName", "testSurname",
                "testEmail", "testPhoneNumber");
        @Test
        public void getRepository() {
        }

        @Test
        public void a_create() {
            Donor created = repository.create(donor);
            Assert.assertEquals(donor.getId(), created.getId());
            System.out.println("Created: " + created);
        }

        @Test
        public void b_read() {
            Donor read = repository.read(donor.getId());
            System.out.println("Read: " + read);
        }

        @Test
        public void c_update() {
            Donor updated = new Donor.Builder().copy(donor).setFirstName("testName")
                    .setSurname("testSurname").setEmail("testEmail").setPhoneNumber("testPhoneNumber")
                    .build();
            updated = repository.update(updated);
            System.out.println("Updated: " + updated);
        }

        @Test
        public void e_delete() {
            boolean deleted = repository.delete(donor.getId());
            Assert.assertTrue(deleted);
            System.out.println("Deleted");
        }

        @Test
        public void d_getAll() {
            System.out.println("Get all: " + repository.getAll());
        }
    }