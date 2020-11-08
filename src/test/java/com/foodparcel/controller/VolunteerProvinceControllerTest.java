package com.foodparcel.controller;

import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;
import com.foodparcel.factory.VolunteerFactory;
import com.foodparcel.factory.VolunteerProvinceFactory;
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
public class VolunteerProvinceControllerTest {

    private static VolunteerProvince volunteerProvince = VolunteerProvinceFactory.buildVolunteerProvince("09a1ee5f-21ca-4d03-b637-6d6233297f89", "9523e4df-5035-414f-8065-092159887c6c");
    private static String SECURITY_USERNAME ="User";
    private static String SECURITY_PASSWORD ="12345";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8888/foodparcel/volunteerProvince/";

    @Test
    public void a_create() {

        //HttpHeaders httpHeaders = new HttpHeaders();
        String url = baseUrl + "create";
        System.out.println();
        System.out.println("volunteerProvince being posted: "+volunteerProvince);
        ResponseEntity<VolunteerProvince> postResponse =  testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, volunteerProvince, VolunteerProvince.class);
        volunteerProvince = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        assertEquals(volunteerProvince.getVolunteerNum(), postResponse.getBody().getVolunteerNum());
        System.out.println("Volunteer Province saved on the data structure: "+postResponse.getBody());

    }


    @Test
    public void b_read() {

        String url = baseUrl+"read/"+volunteerProvince.getVolunteerNum();
        System.out.println(url);
        ResponseEntity<VolunteerProvince> response = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, VolunteerProvince.class);
        //assertNotNull(responseEntity.getBody().getVolunteerNum());
        System.out.println(response.getBody());
        assertEquals(volunteerProvince.getVolunteerNum(), response.getBody().getVolunteerNum());
        System.out.println("Data that has just been added"+ response);

    }

    @Test
    public void c_all() {

        String url = baseUrl+"all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity =  testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }

    @Test
    public void d_update() {

        System.out.println("Before update: "+volunteerProvince);
        VolunteerProvince update = new VolunteerProvince.Builder().copy(volunteerProvince).setVolunteerNum("245115").build();
        String url = baseUrl+"update";
        ResponseEntity<VolunteerProvince> responseEntity = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, update, VolunteerProvince.class);
        //assertNotNull(responseEntity.getBody());
        //assertEquals(update.getVolunteerNum(), responseEntity.getBody().getVolunteerNum());
        System.out.println("After update: "+responseEntity.getBody());

    }

    @Test
    public void e_delete() {

        String url = baseUrl+"delete/"+volunteerProvince.getVolunteerNum();
        testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);


    }
}