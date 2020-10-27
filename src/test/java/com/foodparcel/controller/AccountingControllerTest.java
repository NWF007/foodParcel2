package com.foodparcel.controller;

import com.foodparcel.entity.Accounting;
import com.foodparcel.factory.AccountingFactory;
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
 * Author: Amy Johnston (218188773)
 * AccountingControllerTest.java
 * Submission 9
 * Date: 21 September 2020
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingControllerTest {

    //private static Accounting accounting = AccountingFactory.createAccounting(13467.89,
            //21937.32, 20000.00, 12321, 8273);
    private static Accounting accounting = AccountingFactory.createAccounting(130467.89,
            763773.00, 50000.00, 274528832, 934782847);
    @Autowired
    private TestRestTemplate restTemplate = null;
    private String startURL = "http://localhost:8888/accounting/";
    private HttpStatus statusCode;

    @Test
    public void a_create() {
        String url = startURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<Accounting> postResponse = restTemplate.postForEntity(url, accounting, Accounting.class);

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
        //String url = startURL + "read/" + accounting.getStatementId();
        String url = startURL + "read/" + "496d46f3-cb75-4096-9ae0-b06ec82b1562";
        System.out.println("URL: " + url);

        ResponseEntity<Accounting> responseEntity = restTemplate.getForEntity(url, Accounting.class);
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
        ResponseEntity<Accounting> postResponse = restTemplate.postForEntity(url, updated, Accounting.class);
        statusCode = postResponse.getStatusCode();
        System.out.println("Status code: " + statusCode);

        assertEquals(200, postResponse.getStatusCodeValue());
        assertEquals(accounting.getStatementId(), updated.getStatementId());
        //assertEquals(accounting.getStatementId(), postResponse.getBody().getStatementId());
        assertNotEquals(accounting.getExpense(), updated.getExpense());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        //String url = startURL + "delete/" + accounting.getStatementId();
        String url = startURL + "delete/" + "3f4d1c23-ebcc-4d93-a4b0-00d5d62a90a3";
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Deleted!");
    }

    @Test
    public void d_getAll() {
        String url = startURL + "all";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
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
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
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
                "incomeTransactionId": 12321,
                "expenseTransactionId": 8273
        }*/