package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.EmployeeJob;

public class EmployeeJobFactory {
    public static EmployeeJob create(String employeeNumber, String jobNumber){
        EmployeeJob employeeJob = new EmployeeJob.Builder()
                .setEmployeeNumber(employeeNumber)
                .setJobNumber(jobNumber)
                .build();

        return employeeJob;
    }
}
