

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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Craig Bailey
 * 216178185
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryControllerTest {

    private static Delivery delivery = DeliveryFactory.createDelivery("Long Street", "28 August 2020");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8888/delivery/";

    @Test
    public void a_create(){
        String url = baseURL + "create";
        System.out.println("Url: " + url);
        System.out.println("Post data: " + delivery );
        ResponseEntity<Delivery> postResponse = restTemplate.postForEntity(url, delivery, Delivery.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        delivery = postResponse.getBody();
        System.out.println("Saved data: " +delivery);
        assertEquals(delivery.getDeliveryID(), postResponse.getBody().getDeliveryID());

    }

    @Test
    public void d_getall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> reponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(reponse);
        System.out.println(reponse.getBody());


    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + delivery.getDeliveryID();
        System.out.println("URL: " + url);
        ResponseEntity<Delivery> reponse = restTemplate.getForEntity(url, Delivery.class);
        assertEquals(delivery.getDeliveryID(), reponse.getBody().getDeliveryID());
        System.out.println("Read:" + reponse.getBody());
    }

    @Test
    public void c_update(){
        Delivery updated = new Delivery.Builder().copy(delivery).setDeliveryAddress("test").setDeliveryDate("28 August 2020").build();
        String url = baseURL + "update";
        System.out.println("URL : " +url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Delivery> reponse = restTemplate.postForEntity(url, updated, Delivery.class);
        assertEquals(delivery.getDeliveryID(), reponse.getBody().getDeliveryID());

    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + delivery.getDeliveryID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }




}
