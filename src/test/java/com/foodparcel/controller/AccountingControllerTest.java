package com.foodparcel.controller;

import com.foodparcel.entity.Accounting;
import com.foodparcel.factory.AccountingFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
 * Author: Amy Johnston (218188773)
 * AccountingControllerTest.java
 * Date: 21 September 2020 - Submission 9
 * Edited: 26 October 2020 - Assignment 10
 * Edited: 05 November 2020 - Assignment 11
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingControllerTest {

    private static Accounting accounting = AccountingFactory.createAccounting(13467.89,
            21937.32, 20000.00, 123343321, 82738273);
    //private static Accounting accounting = AccountingFactory.createAccounting(130467.89,
            //763773.10, 50000.00, 274528832, 934782847); //alternative values used for testing
    private static String SECURITY_USERNAME = "Admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String startURL = "http://localhost:8888/accounting/";
    private HttpStatus statusCode;

    @Test
    public void a_create() {
        String url = startURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<Accounting> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, accounting, Accounting.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        accounting = postResponse.getBody();

        statusCode = postResponse.getStatusCode();
        System.out.println("Status code: " + statusCode);
        System.out.println("Saved data: " + accounting);

        //assertEquals(accounting.getStatementId(), postResponse.getBody().getStatementId());
        assertEquals(200, postResponse.getStatusCodeValue());

        System.out.println("Created!");
    }

    @Test
    public void b_read() {
        String url = startURL + "read/" + accounting.getStatementId();

        //Specify the id you want to read by copying it in from when it was created
        //String url = startURL + "read/" + "496d46f3-cb75-4096-9ae0-b06ec82b1562";
        System.out.println("URL: " + url);

        ResponseEntity<Accounting> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Accounting.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("Status code: " + statusCode);

        //assertEquals(accounting.getStatementId(), responseEntity.getBody().getStatementId());
        assertNotNull(accounting.getStatementId());
        assertNotNull(responseEntity.getBody().getStatementId());
        assertEquals(200, responseEntity.getStatusCodeValue());

        System.out.println("Read: " + responseEntity.getBody());
    }

    @Test
    public void c_update() {
        String url = startURL + "update";
        System.out.println("URL: " + url);

        System.out.println("Old: " + accounting);
        Accounting updated = new Accounting.Builder().copy(accounting).setExpense(12937.32).build();
        ResponseEntity<Accounting> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Accounting.class);
        statusCode = postResponse.getStatusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(200, postResponse.getStatusCodeValue());
        assertEquals(accounting.getStatementId(), updated.getStatementId());
        //assertEquals(accounting.getStatementId(), postResponse.getBody().getStatementId());
        assertNotEquals(accounting.getExpense(), updated.getExpense());
        System.out.println("Updated: " + updated);
    }

    @Test
    //@Ignore
    public void f_delete() {
        String url = startURL + "delete/" + accounting.getStatementId();

        //Specify the id you want to delete by copying it in from when it was created
        //String url = startURL + "delete/" + "d52fd493-6f71-45ee-bd82-1734a5c30d32";
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth("Admin", "admin123") //only someone who is an admin can delete
                .delete(url);
        System.out.println("Deleted!");
    }

    @Test
    public void d_getAll() {
        String url = startURL + "all";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, httpEntity, String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("Status code: " + statusCode);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println("All: " + responseEntity.getBody());
    }

    @Test
    public void e_getAllProfits() {
        String url = startURL + "profits";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, httpEntity, String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("Status code: " + statusCode);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }
}

//POSTMAN DATA I USED FOR TESTING
        /*{
            "income": 13467.89,
                "expense": 21937.32,
                "budget": 20000.00,
                "incomeTransactionId": 123343321,
                "expenseTransactionId": 82738273
        }*/