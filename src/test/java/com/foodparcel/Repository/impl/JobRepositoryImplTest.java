package com.foodparcel.Repository.impl;

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
        System.out.println("All jobs: " +jobRepository.getAll());
        assertNotNull(job);
    }

    @Test
    public void a_create() {
        Job created = jobRepository.create(job);
        Assert.assertEquals(job.getJobTitle(), created.getJobTitle());
        System.out.println("Created: " +created);
    }

    @Test
    public void b_read() {
        Job jobT = jobRepository.read(job.getJobTitle());

        assertNotNull(jobRepository.getAll());
        System.out.println("All the jobs: " + jobT);
    }

    @Test
    public void c_update() {
        Job jobUpdate = new Job.JobBuilder().copy(job).setJobTitle("Manager").build();
        jobUpdate = jobRepository.update(jobUpdate);
        assertNotEquals(job, jobUpdate);
        System.out.println(jobUpdate);

    }

    @Test
    public void e_delete() {
        System.out.println("All jobs: " +jobRepository.getAll());
        jobRepository.delete(job.getJobTitle());
        System.out.println("All jobs: " +jobRepository.getAll());
        assertNull(job);
    }
}