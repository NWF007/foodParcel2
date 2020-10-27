package com.foodparcel.Service.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.JobRepository;
import com.foodparcel.Service.JobService;
import com.foodparcel.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Set<Job> getAll() {
        return this.jobRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Job create(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public Job read(String s) {
        return this.jobRepository.findById(s).orElseGet(null);
    }

    @Override
    public Job update(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public void delete(String s) {
        this.jobRepository.deleteById(s);
    }
}
