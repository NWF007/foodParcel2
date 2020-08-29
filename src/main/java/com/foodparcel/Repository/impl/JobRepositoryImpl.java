package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.JobRepository;
import com.foodparcel.entity.Job;

import java.util.HashSet;
import java.util.Set;

public class JobRepositoryImpl implements JobRepository {

    private static JobRepositoryImpl jobRepository = null;
    private Set<Job> jobs;

    public JobRepositoryImpl(){
        jobs = new HashSet<>();
    }

    public static JobRepository getJobRepository(){
        if (jobRepository == null)
            jobRepository = new JobRepositoryImpl();
        return jobRepository;
    }


    @Override
    public Set<Job> getAll() {
        return jobs;
    }

    @Override
    public Job create(Job job) {
        jobs.add(job);
        return job;
    }

    @Override
    public Job read(String title) {
        return jobs.stream()
                .filter(job -> job.getJobTitle().equalsIgnoreCase(title))
                .findAny()
                .orElse(null);
    }

    @Override
    public Job update(Job job) {

        Job jobTitle = read(job.getJobTitle());
        if (jobTitle != null){
            jobs.remove(jobTitle);
            jobs.add(job);
            return job;
        }
        return null;
    }

    @Override
    public void delete(String jobTitle) {
        Job job = read(jobTitle);

        if (job != null)
            jobs.remove(job);
    }
}
