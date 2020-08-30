package com.foodparcel.Repository.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.JobRepository;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.JobFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobRepositoryImplTest {

    private static JobRepository jobRepository = JobRepositoryImpl.getJobRepository();
    private static Job job = JobFactory.createJob("Managerr");

    @Test
    public void d_getAll() {
        Assert.assertNotNull(jobRepository);
        System.out.println("Get all: " + jobRepository.getAll());
    }

    @Test
    public void a_create() {
        Job created = jobRepository.create(job);
        Assert.assertEquals(job.getJobTitle(), created.getJobTitle());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Job readJob = jobRepository.read(job.getJobTitle());

        Assert.assertNotNull(jobRepository.getAll());
        System.out.println("Read: " + readJob);
    }

    @Test
    public void c_update() {
        Job jobUpdate = new Job.JobBuilder().copy(job).setJobTitle("Manager").build();
        jobUpdate = jobRepository.update(jobUpdate);
        Assert.assertNotEquals(job, jobUpdate);
        System.out.println("Updated: "+jobUpdate);
    }

    @Test
    public void e_delete() {
        jobRepository.delete(job.getJobTitle());
        System.out.println("Deleted: " +jobRepository.getAll());
        Assert.assertNotNull(job);
    }
}