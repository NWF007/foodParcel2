package com.foodparcel.Repository;

import com.foodparcel.entity.Job;

import java.util.Set;

public interface JobRepository extends IRepository<Job, String> {
    Set<Job> getAll();
}
