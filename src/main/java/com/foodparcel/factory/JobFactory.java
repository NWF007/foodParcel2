package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Job;
import com.foodparcel.util.IDGenerator;

public class JobFactory {

    public static Job createJob(String jobTitle){
        String jobNum = IDGenerator.generateId();
        Job job = new Job.JobBuilder()
                .setJobNumber(jobNum)
                .setJobTitle(jobTitle)
                .build();

        return job;
    }

}
