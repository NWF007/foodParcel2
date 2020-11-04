package com.foodparcel.Service.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Service.JobService;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.JobFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobServiceImplTest {

    @Autowired
    private static JobService jobService;
    private static Job job = JobFactory.createJob("Accountantt");

    @Test
    public void d_getAll() {
        Assert.assertNotNull(jobService);
        System.out.println("Get all: " + jobService.getAll());
    }

    @Test
    public void a_create() {
        Job jobCreated = jobService.create(job);
        Assert.assertSame(job.getJobTitle(), jobCreated.getJobTitle());
        System.out.println("Create: " + jobCreated);
    }

    @Test
    public void b_read() {
        Job jobRead = jobService.read(job.getJobTitle());
        Assert.assertNotNull(jobRead);
        System.out.println("Read: " +jobRead);
    }

    @Test
    public void c_update() {
        Job jobUpdate = new Job.JobBuilder().copy(job).setJobTitle("Accountant").build();
        jobUpdate = jobService.update(jobUpdate);
        Assert.assertNotEquals(job , jobUpdate);
        System.out.println("Updated: " +jobUpdate);
    }

    @Test
    public void e_delete() {
        jobService.delete(job.getJobTitle());
        Assert.assertNotNull(job);
        System.out.println("Deleted: " + jobService.getAll());
    }
}