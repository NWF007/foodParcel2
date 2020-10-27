package com.foodparcel.controller;

import com.foodparcel.entity.Volunteer;
import com.foodparcel.factory.VolunteerFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class VolunteerControllerTest {


    private static Volunteer volunteer = VolunteerFactory.builderVolunteer("Mncedisi","Mngadi",0745664245,911451256);

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8888/volunteer/";



    @Test
    public void a_create() {

        //HttpHeaders httpHeaders = new HttpHeaders();
        String url = baseUrl + "create";
        System.out.println();
        System.out.println("volunteer being posted: "+volunteer);
        ResponseEntity<Volunteer> postResponse =  testRestTemplate.postForEntity(url, volunteer, Volunteer.class);
        volunteer = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        assertEquals(volunteer.getVolunteerNum(), postResponse.getBody().getVolunteerNum());
        System.out.println("Volunteer saved on the data structure: "+postResponse.getBody());



    }

    @Test
    public void b_read(){


        String url = baseUrl+"read/"+volunteer.getVolunteerNum();
        System.out.println(url);
        ResponseEntity<Volunteer> response = testRestTemplate.getForEntity(url, Volunteer.class);
        //assertNotNull(responseEntity.getBody().getVolunteerNum());
        System.out.println(response.getBody());
        assertEquals(volunteer.getVolunteerNum(), response.getBody().getVolunteerNum());
        System.out.println("Data that has just been added"+ response);

    }

    @Test
    public void c_update(){

        System.out.println("Before update: "+volunteer);
        Volunteer update = new Volunteer.Builder().copy(volunteer).setFirstName("Bongani").build();
        String url = baseUrl+"update";
        ResponseEntity<Volunteer> responseEntity = testRestTemplate.postForEntity(url, update, Volunteer.class);
        assertNotNull(responseEntity.getBody());
        assertEquals(volunteer.getVolunteerNum(), responseEntity.getBody().getVolunteerNum());
        System.out.println("After update: "+responseEntity.getBody());

    }


    @Test
    public void d_getAll() {

        String url = baseUrl+"all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity =  testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }

    @Test
    public void e_availability(){

        System.out.println("Before availability update: "+volunteer);
        Volunteer availabilityStatus = new Volunteer.Builder().copy(volunteer).setAvailability(true).build();
        String url = baseUrl+"availability";
        ResponseEntity<Volunteer> responseEntity = testRestTemplate.postForEntity(url, availabilityStatus, Volunteer.class);
        assertNotSame(availabilityStatus.getVolunteerNum(), responseEntity.getBody().getVolunteerNum());
        System.out.println("After availability update: "+responseEntity.getBody());

    }

    @Test
    public void f_delete(){

        String url = baseUrl+"delete/"+volunteer.getVolunteerNum();
        testRestTemplate.delete(url);

    }


}