package com.foodparcel.controller;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;
import com.foodparcel.factory.JobFactory;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobControllerTest {

    private static Job job = JobFactory.createJob("Employee2");
    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8888/job/";

    @Test
    public void a_create() {
        System.out.println("URL: " +baseUrl+"create");
        System.out.println("Post data: " +job);
        ResponseEntity<Job> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(baseUrl+"create", job, Job.class);
        job = postResponse.getBody();
        assertEquals(200, postResponse.getStatusCodeValue());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + job.getJobNumber();
        System.out.println("URL: " +url);
        ResponseEntity<Job> res = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Job.class);
        assertEquals(200, res.getStatusCodeValue());
        System.out.println(res);
    }

    @Test
    public void c_update() {
        Job jobUpdate = new Job.JobBuilder().copy(job).setJobTitle("Supervisor").build();
        String url = baseUrl + "update";
        System.out.println("URL: " +url);
        System.out.println("Data: " + jobUpdate);

        ResponseEntity<Job> res = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, jobUpdate, Job.class);
    }

    @Test
//    @Ignore
    public void e_delete() {
        String url = baseUrl + "/delete/" + job.getJobNumber();
        System.out.println("URL: " +url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
        //assertEquals();
    }

    @Test
    public void d_getAll() {
        System.out.println("URL: " +baseUrl+"all");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> res = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(baseUrl + "all", HttpMethod.GET, entity, String.class);
        System.out.println(res);
        System.out.println(res.getBody());
        assertEquals(200, res.getStatusCodeValue());
    }
}