package com.foodparcel.Service.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.JobRepository;
import com.foodparcel.Repository.impl.JobRepositoryImpl;
import com.foodparcel.Service.JobService;
import com.foodparcel.entity.Job;

import java.util.Set;

public class JobServiceImpl implements JobService {

    private static JobService jobService = null;
    private JobRepository jobRepository;

    private JobServiceImpl(){
        this.jobRepository = JobRepositoryImpl.getJobRepository();
    }

    public static JobService getJobService(){
        if (jobService == null) jobService = new JobServiceImpl();
        return jobService;
    }

    @Override
    public Set<Job> getAll() {
        return this.jobRepository.getAll();
    }

    @Override
    public Job create(Job job) {
        return this.jobRepository.create(job);
    }

    @Override
    public Job read(String s) {
        return this.jobRepository.read(s);
    }

    @Override
    public Job update(Job job) {
        return this.jobRepository.update(job);
    }

    @Override
    public void delete(String s) {
        this.jobRepository.delete(s);
    }
}
