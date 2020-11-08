package com.foodparcel.controller;

import com.foodparcel.entity.EmployeeJob;
import com.foodparcel.entity.EmployeeJobId;
import com.foodparcel.factory.EmployeeJobFactory;
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
public class EmployeeJobControllerTest {

    private static EmployeeJob employeeJob = EmployeeJobFactory.create("5fadf8-9e1e-4ba2-a30d-63b9b7d9affc", "35c0624c-d70f-4c5f-91d5-b0254e3c8009");
    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8888/employeejob/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        System.out.println("URL: " +url);
        System.out.println("Post data: " +employeeJob);
        ResponseEntity<EmployeeJob> postResponse = testRestTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, employeeJob, EmployeeJob.class);
        employeeJob = postResponse.getBody();
        assertEquals(200, postResponse.getStatusCodeValue());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + employeeJob.getJobNumber();
        System.out.println("URL: " + url);
        ResponseEntity<EmployeeJob> response = testRestTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, EmployeeJob.class);
        System.out.println(response);
        //assertEquals(employeeJob.getJobNumber(), response.getBody().getJobNumber());
    }

    @Test
    public void c_update() {
        EmployeeJob employeeJobUpdate = new EmployeeJob.Builder().copy(employeeJob).setJobNumber("").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " +employeeJobUpdate);
        ResponseEntity<EmployeeJob> response = testRestTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, employeeJobUpdate, EmployeeJob.class);
        assertNotEquals(employeeJob.getJobNumber(), response.getBody().getJobNumber());
    }

    @Test
//    @Ignore
    public void e_delete() {
        String url = baseUrl + "delete/" + employeeJob.getJobNumber();
        System.out.println("Delete URL: " +url);
        testRestTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}