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

    private static VolunteerProvince volunteerProvince = VolunteerProvinceFactory.buildVolunteerProvince("dc63e888-de2a-4e2e-9faa-f3c11fcd0494", "72d861e3-ef33-4390-9bc4-17ab5da3924e");


    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8888/volunteerProvince/";

    @Test
    public void a_create() {

        //HttpHeaders httpHeaders = new HttpHeaders();
        String url = baseUrl + "create";
        System.out.println();
        System.out.println("volunteerProvince being posted: "+volunteerProvince);
        ResponseEntity<VolunteerProvince> postResponse =  testRestTemplate.postForEntity(url, volunteerProvince, VolunteerProvince.class);
        volunteerProvince = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        assertEquals(volunteerProvince.getVolunteerNum(), postResponse.getBody().getVolunteerNum());
        System.out.println("Volunteer Province saved on the data structure: "+postResponse.getBody());

    }


    @Test
    public void b_read() {

        String url = baseUrl+"read/"+volunteerProvince.getVolunteerNum();
        System.out.println(url);
        ResponseEntity<VolunteerProvince> response = testRestTemplate.getForEntity(url, VolunteerProvince.class);
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
        ResponseEntity<String> responseEntity =  testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }

    @Test
    public void d_update() {

        System.out.println("Before update: "+volunteerProvince);
        VolunteerProvince update = new VolunteerProvince.Builder().copy(volunteerProvince).setVolunteerNum("245115").build();
        String url = baseUrl+"update";
        ResponseEntity<VolunteerProvince> responseEntity = testRestTemplate.postForEntity(url, update, VolunteerProvince.class);
        assertNotNull(responseEntity.getBody());
        assertEquals(update.getVolunteerNum(), responseEntity.getBody().getVolunteerNum());
        System.out.println("After update: "+responseEntity.getBody());

    }

    @Test
    public void e_delete() {

        String url = baseUrl+"delete/"+volunteerProvince.getVolunteerNum();
        testRestTemplate.delete(url);


    }
}