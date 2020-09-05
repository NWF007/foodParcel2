package com.foodparcel.Service.impl;

import com.foodparcel.Repository.ProvinceRepository;
import com.foodparcel.Repository.ProvinceRepositoryImpl;
import com.foodparcel.Service.ProvinceService;
import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.factory.ProvinceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Mncedisi Mngadi
 * 214210286
 * 3B
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProvinceServiceImplTest {

    private static ProvinceService service = ProvinceServiceImpl.getService();
    private static Province province = ProvinceFactory.builderProvince("Westernii Cape");

    @Test
    public void a_create() {

        Province created = service.create(province);
        assertEquals(province.getProvinceId(), created.getProvinceId());
        System.out.println("Created: "+created);


    }

    @Test
    public void b_read() {

        Province read = service.read(province.getProvinceId());
        assertNotNull(read);
        System.out.println("Read: "+read);

    }

    @Test
    public void c_update() {

        Province updated = new Province.Builder().copy(province).setProvinceDesc("Western Cape").build();
        updated = service.update(updated);
        assertNotEquals(updated, province);
        System.out.println("Updated: "+updated);

    }

    @Test
    public void d_getAll() {

        Set<Province> provinces = service.getAll();
        assertEquals(1,provinces.size());
        System.out.println("These are all Provinces: "+provinces);

    }

    @Test
    public void e_delete1() {

        boolean deleted  = service.delete1(province.getProvinceId());
        Assert.assertTrue(deleted);
        System.out.println("Deleted: "+province);

    }
}