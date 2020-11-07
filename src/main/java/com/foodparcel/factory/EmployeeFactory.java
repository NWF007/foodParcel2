package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Employee;
import com.foodparcel.entity.Job;
import com.foodparcel.util.IDGenerator;

public class EmployeeFactory {

    public static Employee createEmployee( String identityNumber, String firstName, String lastName, String employmentDate){
        String empNum = IDGenerator.generateId();
        Employee employee = new Employee.EmployeeBuilder()
                .setEmployeeNumber(empNum)
                .setIdentityNumber(identityNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmploymentDate(employmentDate)
                .build();

        return employee;
    }
}
