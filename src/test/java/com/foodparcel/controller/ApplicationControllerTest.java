package com.foodparcel.controller;

import com.foodparcel.entity.Application;
import com.foodparcel.factory.ApplicationFactory;
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

public class ApplicationControllerTest {
    Application application = ApplicationFactory.createApplication("2314567","Danielle",
            "Johnson" ,"Mandalay", "0744992123 ",
            3,2500.89);

    @Autowired
    private TestRestTemplate testRestTempl = null;
    private String base = "http://localhost:8888/application";

    @Test
    public void a_create() {

        String url = base + "/create";
        ResponseEntity<Application> responseEntity = testRestTempl.postForEntity(url ,
                application ,Application.class);
        application = responseEntity.getBody();
        assertNotSame("hgvfd",application.getFirstName());
        System.out.println("Correct First Name : " + application.getFirstName());
        System.out.println("Application captured : " +application);
    }

    @Test
    public void b_read() {
        String url = base + "/read/" + application.getId();
        System.out.println(url);
        ResponseEntity<Application> readResponse = testRestTempl.getForEntity(url, Application.class);
        System.out.println(readResponse.getStatusCode());
        assertNotNull(readResponse.getBody().getId());
        System.out.println("ID :" + readResponse.getBody().getId());

    }
    @Test
    public void c_update(){
        Application updateApplication = new Application.Builder().copy(application).setnumberOfDependants(1).build();
        String url = base + "/update";
        System.out.println("Previous data  : " + application);
        System.out.println("Updated data : " + updateApplication);
        ResponseEntity<Application> updateResponse = testRestTempl.postForEntity(url, updateApplication, Application.class);
        assertNotEquals(application.getNumberOfDependants(),updateResponse.getBody().getNumberOfDependants());

    }

    @Test
    public void d_delete(){
        String url = base + "/delete/"+ application.getId();
        testRestTempl.delete(url);


    }
    @Test
    public void e_getAppl(){
        String url = base + "/getApplications";
        HttpHeaders http = new HttpHeaders();
        HttpEntity<String> e = new HttpEntity<>(null,http);
        ResponseEntity<String> response = testRestTempl.exchange(url, HttpMethod.GET,e,String.class);
        System.out.println(response);

    }

}