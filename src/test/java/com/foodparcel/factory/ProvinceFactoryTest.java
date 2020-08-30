package com.foodparcel.factory;

import com.foodparcel.entity.Province;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.UUID;

public class ProvinceFactoryTest extends TestCase {

    public void testCreateProvince() {


            Province province= ProvinceFactory.createProvince(UUID.randomUUID().toString(),"Western Cape");
            Assert.assertNotNull(province);
            System.out.println(province);


    }
}