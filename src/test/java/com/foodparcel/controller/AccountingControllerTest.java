package com.foodparcel.controller;

import com.foodparcel.entity.Accounting;
import com.foodparcel.factory.AccountingFactory;
import com.sun.istack.internal.NotNull;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingControllerTest {

    private static Accounting accounting = AccountingFactory.createAccounting(13467.89,
            21937.32, 20000.00, 12321, 8273);

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String startURL = "http://localhost:8888/accounting/";

    @Test
    public void a_create() {
        String url = startURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<Accounting> postResponse = restTemplate.postForEntity(url, accounting, Accounting.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        accounting = postResponse.getBody();

        System.out.println("Saved data: " + accounting);
        assertEquals(accounting.getStatementId(), postResponse.getBody().getStatementId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
        System.out.println("Created!");
    }

    @Test
    public void b_read() {
        String url = startURL + "read/" + accounting.getStatementId();

        ResponseEntity<Accounting> responseEntity = restTemplate.getForEntity(url, Accounting.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println(statusCode);

        assertEquals(accounting.getStatementId(), responseEntity.getBody().getStatementId());
        assertNotNull(accounting.getStatementId());
        assertNotNull(responseEntity.getBody().getStatementId());

        System.out.println("Read: " + responseEntity.getBody());
    }

    @Test
    public void c_update() {
        System.out.println("Old: " + accounting);
        Accounting updated = new Accounting.Builder().copy(accounting).setExpense(12937.32).build();
        String url = startURL + "update";
        ResponseEntity<Accounting> postResponse = restTemplate.postForEntity(url, updated, Accounting.class);

        assertEquals(accounting.getStatementId(), updated.getStatementId());
        assertEquals(accounting.getStatementId(), postResponse.getBody().getStatementId());
        assertNotEquals(accounting.getExpense(), updated.getExpense());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        String url = startURL + "delete/" + accounting.getStatementId();
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

        assertNotNull(responseEntity);
        System.out.println("All: " + accounting);
    }

    //Demonstrating Business Logic when it is met
    // -> this will display the now updated stuff as we are making a Profit since our expense was changed
    @Test
    public void e_getAllProfits() {
        String url = startURL + "profits";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        assertNotNull(responseEntity);
        System.out.println(responseEntity);
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