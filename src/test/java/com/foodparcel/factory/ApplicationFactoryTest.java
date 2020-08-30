package com.foodparcel.factory;

import com.foodparcel.entity.Application;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationFactoryTest {

    @Test
    public void createApplication() {
        Application a = ApplicationFactory.createApplication("941209130" , "Danielle",
                "Johnson" ,"074456567","Mitchells Plain",2,3500.0);
        Assert.assertTrue(!a.getId().equals("0"));
    }
}