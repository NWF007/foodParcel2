package com.foodparcel.factory;

import com.foodparcel.entity.EmployeeJob;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeJobFactoryTest {

    @Test
    public void create() {
        EmployeeJob employeeJob = EmployeeJobFactory.create("a625fe11-86a1-4163-8b99-4463a0da238f", "35c0624c-d70f-4c5f-91d5-b0254e3c8009");
        System.out.println(employeeJob);
        Assert.assertNotNull(employeeJob);
    }
}