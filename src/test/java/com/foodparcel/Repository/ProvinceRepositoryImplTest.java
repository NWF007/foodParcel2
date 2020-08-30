package com.foodparcel.Repository;

import com.foodparcel.entity.Province;
import com.foodparcel.factory.ProvinceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
//Mncedisi Mngadi
//214210286

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProvinceRepositoryImplTest {

    private static ProvinceRepository provinceRepository = ProvinceRepositoryImpl.getRepository();
    private static Province province = ProvinceFactory.builderProvince("Westernii Cape");

    @Test
    public void a_create() {

        Province created = provinceRepository.create(province);
        assertEquals(province.getProvinceId(), created.getProvinceId());
        System.out.println("Created: "+created);

    }

    @Test
    public void b_read() {

        Province read = provinceRepository.read(province.getProvinceId());
        System.out.println(read);


    }

    @Test
    public void c_update() {

        Province updated = new Province.Builder().copy(province).setProvinceDesc("Western Cape").build();
        updated = provinceRepository.update(updated);
        assertNotEquals(updated, province);
        System.out.println("Updated: "+updated);
    }

    @Test
    public void d_getAll() {

        assertNotNull(province);
        System.out.println("Display: "+provinceRepository.getAll());

    }

    @Test
    public void e_delete1() {

        boolean deleted = provinceRepository.delete1(province.getProvinceId());
        Assert.assertTrue(deleted);
        System.out.println("Deleted: "+province);

    }
}