package com.foodparcel.controller;

import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.factory.ProvinceFactory;
import com.foodparcel.factory.VolunteerFactory;
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
public class ProvinceControllerTest {

    private static Province province = ProvinceFactory.builderProvince("Kwazulu natal");
    private static String SECURITY_USERNAME ="User";
    private static String SECURITY_PASSWORD ="12345";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8888/foodparcel/province/";

    @Test
    public void a_create() {

        //HttpHeaders httpHeaders = new HttpHeaders();
        String url = baseUrl + "create";
        System.out.println();
        System.out.println("province being posted: "+province);
        ResponseEntity<Province> postResponse =  testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, province, Province.class);
        province = postResponse.getBody();
        assertNotNull(postResponse.getBody());
        assertEquals(province.getProvinceId(), postResponse.getBody().getProvinceId());
        assertEquals(200, postResponse.getStatusCodeValue());
        System.out.println("Province saved on the data structure: "+postResponse.getBody());

    }

    @Test
    public void d_getAll() {

        String url = baseUrl+"all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity =  testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }

    @Test
    public void b_read() {

        String url = baseUrl+"read/"+province.getProvinceId();
        System.out.println(url);
        ResponseEntity<Province> response = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Province.class);
        //assertNotNull(responseEntity.getBody().getVolunteerNum());
        System.out.println(response.getBody());
        assertEquals(province.getProvinceId(), response.getBody().getProvinceId());
        System.out.println("Data that has just been added"+ response);

    }

    @Test
    public void c_update() {

        System.out.println("Before update: "+province);
        Province update = new Province.Builder().copy(province).setProvinceDesc("Western Cape").build();
        String url = baseUrl+"update";
        ResponseEntity<Province> responseEntity = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, update, Province.class);
        assertNotNull(responseEntity.getBody());
        assertEquals(province.getProvinceId(), responseEntity.getBody().getProvinceId());
        System.out.println("After update: "+responseEntity.getBody());

    }

    @Test
    public void e_delete() {

        String url = baseUrl+"delete/"+province.getProvinceId();
        testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);

    }
}