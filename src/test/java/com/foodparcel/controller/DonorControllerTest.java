package com.foodparcel.controller;

import com.foodparcel.entity.Donation;
import com.foodparcel.entity.Donor;
import com.foodparcel.factory.DonationFactory;
import com.foodparcel.factory.DonorFactory;
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
public class DonorControllerTest {

    private static Donor donor = DonorFactory.createDonor("Yusrah", "Soeker", "yusrah.soeker@gmail.com",
            "0722499159");
    private static String SECURITY_USERNAME = "User";
    private static String SECURITY_PASSWORD = "12345";

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8888/donor/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        ResponseEntity<Donor> donorResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, donor, Donor.class);
        assertNotNull(donorResponse);
        assertNotNull(donorResponse.getBody());
        donor = donorResponse.getBody();
        //System.out.println("Saved data: " + donation);
        System.out.println("URL: " + url);
        System.out.println("Created data: " + donor);
        assertEquals(donor.getId(), donorResponse.getBody().getId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + donor.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Donor> donorResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Donor.class);
        assertEquals(200, donorResponse.getStatusCodeValue());
        System.out.println("Read:" + donorResponse.getBody());
    }

    @Test
    public void c_update() {
        Donor updated = new Donor.Builder().copy(donor).setFirstName("Yusrah").setSurname("Soeker").setEmail("yusrah@gmail.com")
                .setPhoneNumber("0721049819").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + updated);
        System.out.println("Update completed!");
        ResponseEntity<Donor> donorResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Donor.class);
        assertNotEquals(donor.getEmail(), updated.getEmail());
        //assertEquals(donor.getFirstName(), donorResponse.getBody().getFirstName());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + donor.getId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
        System.out.println("Delete completed!");
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders donorHeaders = new HttpHeaders();
        HttpEntity<String> donorEntity = new HttpEntity<>(null, donorHeaders);
        ResponseEntity<String> donorResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, donorEntity, String.class);
        assertNotNull(donorResponse);
        System.out.println(donorResponse);
        System.out.println(donorResponse.getBody());
    }
}