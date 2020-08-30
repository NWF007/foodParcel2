package com.foodparcel.Repository;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;

import java.util.Set;

public interface JobRepository extends IRepository<Job, String> {
    Set<Job> getAll();
}
