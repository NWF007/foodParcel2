package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobFactoryTest {

    @Test
    public void getJob() {
        Job job = JobFactory.createJob("Accountant");
        System.out.println(job);
        Assert.assertNotNull(job);
    }
}