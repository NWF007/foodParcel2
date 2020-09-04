package com.foodparcel.Service;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;

import java.util.Set;

public interface JobService extends IService<Job, String> {

    Set<Job> getAll();
}
