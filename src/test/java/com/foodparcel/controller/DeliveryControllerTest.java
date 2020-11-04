

package com.foodparcel.controller;


import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Craig Bailey
 * 216178185
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryControllerTest {

    private static Delivery delivery = DeliveryFactory.createDelivery("Long Street", "28 August 2020");
    private static String SECURITY_USERNAME = "Admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8888/delivery/";

    @Test
    public void a_create(){
        String url = baseURL + "create";
        ResponseEntity<Delivery> deliveryResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, delivery, Delivery.class);
        assertNotNull(deliveryResponse);
        assertNotNull(deliveryResponse.getBody());
        delivery = deliveryResponse.getBody();
        System.out.println("URL: " + url);
        System.out.println("Created data: " + delivery);
        assertEquals(HttpStatus.OK, deliveryResponse.getStatusCode());
        assertEquals(delivery.getDeliveryID(), deliveryResponse.getBody().getDeliveryID());

    }


    @Test
    public void b_read(){
        String url = baseURL + "read/" + delivery.getDeliveryID();
        System.out.println("URL: " + url);
        ResponseEntity<Delivery> deliveryResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Delivery.class);

        assertEquals(200, deliveryResponse.getStatusCodeValue());
        System.out.println("Read:" + deliveryResponse.getBody());
    }

    @Test
    public void c_update(){
        Delivery updated = new Delivery.Builder().copy(delivery).setDeliveryAddress("test").setDeliveryDate("29 August 2020").build();
        String url = baseURL + "update";
        System.out.println("URL : " +url);
        System.out.println("Updated data:" + updated);
        System.out.println("Update complete!");
        ResponseEntity<Delivery> deliveryResponse = restTemplate.postForEntity(url, updated, Delivery.class);
        assertNotEquals(delivery.getDeliveryDate(), updated.getDeliveryDate());
        assertEquals(delivery.getDeliveryID(), deliveryResponse.getBody().getDeliveryID());

    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + delivery.getDeliveryID();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth("Admin", "admin123").delete(url);
        System.out.println("Delete completed!");
    }

    @Test
    public void d_getall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> deliveryResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(deliveryResponse);
        System.out.println(deliveryResponse.getBody());


    }




}
