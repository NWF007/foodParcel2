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
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ApplicationControllerTest {
    Application application = ApplicationFactory.createApplication("2314567","Danielle",
            "Johnson" ,"Mandalay", "0744992123 ",
            3,2500.89);

    //User
    private static String SECURITY_USERNAME = "User";
    private static String SECURITY_PASSWORD = "12345";
    //Admin
    private static String SECURITY_U = "Admin";
    private static String SECURITY_P = "admin123";

    @Autowired
    private TestRestTemplate testRestTempl = null;
    private String base = "http://localhost:8888/application";

    @Test
    public void a_create() {

        String url = base + "/create";
        ResponseEntity<Application> responseEntity = testRestTempl.withBasicAuth(SECURITY_U, SECURITY_P).postForEntity(url ,
                application ,Application.class);
        application = responseEntity.getBody();
        assertNotSame("hgvfd",application.getFirstName());
        System.out.println("Correct First Name : " + application.getFirstName());
        System.out.println("Application captured : " +application);
        System.out.println(responseEntity);
    }

    @Test
    public void b_read() {
        String url = base + "/read/" + application.getId();
        System.out.println(url);
        ResponseEntity<Application> readResponse = testRestTempl.withBasicAuth(SECURITY_USERNAME , SECURITY_PASSWORD).getForEntity(url, Application.class);
        System.out.println(readResponse.getStatusCode());
        assertNotNull(readResponse.getBody().getId());
        System.out.println("ID :" + readResponse.getBody().getId());
        System.out.println("Applicant details : " + readResponse.getBody());
        System.out.println(readResponse);

    }
    @Test
    public void c_update(){
        Application updateApplication = new Application.Builder().copy(application).setnumberOfDependants(1).build();
        String url = base + "/update";
        System.out.println("Previous data  : " + application);
        System.out.println("Updated data : " + updateApplication);
        ResponseEntity<Application> updateResponse = testRestTempl.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updateApplication, Application.class);
        assertNotEquals(application.getNumberOfDependants(),updateResponse.getBody().getNumberOfDependants());
        System.out.println(updateResponse);

    }

    @Test
    public void d_getAppl(){
        String url = base + "/getApplications";
        HttpHeaders http = new HttpHeaders();
        HttpEntity<String> e = new HttpEntity<>(null,http);
        ResponseEntity<String> response = testRestTempl.withBasicAuth(SECURITY_USERNAME , SECURITY_PASSWORD).exchange(url, HttpMethod.GET,e,String.class);
        System.out.println(response);

    }
    @Test
    public void e_delete(){
        String url = base + "/delete/"+ application.getId();
        testRestTempl.withBasicAuth(SECURITY_USERNAME , SECURITY_PASSWORD).delete(url);



    }
}