package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;

public class JobFactory {

    public static Job createJob(String jobTitle){
        Job job = new Job.JobBuilder()
                .setJobTitle(jobTitle)
                .build();

        return job;
    }

}
