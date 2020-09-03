package com.foodparcel.Service;

import com.foodparcel.entity.Job;

import java.util.Set;

public interface JobService extends IService<Job, String> {

    Set<Job> getAll();
}
