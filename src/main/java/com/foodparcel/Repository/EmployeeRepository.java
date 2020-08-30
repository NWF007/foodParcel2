package com.foodparcel.Repository;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Employee;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {

    Set<Employee> getAll();
}
