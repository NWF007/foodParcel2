package com.foodparcel.controller;

import com.foodparcel.entity.Donation;
import com.foodparcel.entity.Donor;
import com.foodparcel.factory.DonationFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonationControllerTest {

    private static Donation donation = DonationFactory.createDonation("testDate", 100);

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8888/donation/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        ResponseEntity<Donation> donationResponse = restTemplate.postForEntity(url, donation, Donation.class);
        assertNotNull(donationResponse);
        assertNotNull(donationResponse.getBody());
        donation = donationResponse.getBody();
        //System.out.println("Saved data: " + donation);
        System.out.println("URL: " + url);
        System.out.println("Created data: " + donation);
        assertEquals(donation.getDonationId(), donationResponse.getBody().getDonationId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + donation.getDonationId();
        System.out.println("URL: " + url);
        ResponseEntity<Donation> donationResponse = restTemplate.getForEntity(url, Donation.class);
        assertEquals(200, donationResponse.getStatusCodeValue());
        System.out.println("Read:" + donationResponse.getBody());
    }

    @Test
    public void c_update() {
        Donation updated = new Donation.Builder().copy(donation).setDonationDate("test")
                .setDonateAmount(150).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + updated);
        System.out.println("Update completed!");
        ResponseEntity<Donation> donationResponse = restTemplate.postForEntity(url, updated, Donation.class);
        assertNotEquals(donation.getDonationDate(), updated.getDonationDate());
        assertEquals(donation.getDonationId(), donationResponse.getBody().getDonationId());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + donation.getDonationId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Delete completed!");
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders donationHeaders = new HttpHeaders();
        HttpEntity<String> donationEntity = new HttpEntity<>(null, donationHeaders);
        ResponseEntity<String> donationResponse = restTemplate.exchange(url, HttpMethod.GET, donationEntity, String.class);
        assertNotNull(donationResponse);
        System.out.println(donationResponse);
        System.out.println(donationResponse.getBody());
    }
}