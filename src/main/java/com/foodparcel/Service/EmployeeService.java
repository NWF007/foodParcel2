package com.foodparcel.Service;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Employee;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {

    Set<Employee> getAll();
}
