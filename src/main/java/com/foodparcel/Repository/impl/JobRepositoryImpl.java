package com.foodparcel.Repository.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.JobRepository;
import com.foodparcel.entity.Job;

import java.util.HashSet;
import java.util.Set;

public class JobRepositoryImpl implements JobRepository {

    private static JobRepositoryImpl jobRepository = null;
    private Set<Job> jobs;

    public JobRepositoryImpl(){
        this.jobs = new HashSet<>();
    }

    public static JobRepository getJobRepository(){
        if (jobRepository == null)
            jobRepository = new JobRepositoryImpl();
        return jobRepository;
    }


    @Override
    public Set<Job> getAll() {
        return this.jobs;
    }

    @Override
    public Job create(Job job) {
        this.jobs.add(job);
        return job;
    }

    @Override
    public Job read(String title) {
        return this.jobs.stream()
                .filter(job -> job.getJobTitle()
                        .trim()
                        .equalsIgnoreCase(title))
                .findAny()
                .orElse(null);
    }

    @Override
    public Job update(Job job) {
        Job oldJob = read(job.getJobTitle());
        if (oldJob != null){
            this.jobs.remove(oldJob);
            this.jobs.add(job);
        }
        return job;
    }

    @Override
    public void delete(String jobTitle) {
        Job job = read(jobTitle);

        if (job != null) {
            this.jobs.remove(job);
        }
    }
}
