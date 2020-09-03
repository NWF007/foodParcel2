package com.foodparcel.Service;

import com.foodparcel.entity.Employee;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {

    Set<Employee> getAll();
}
