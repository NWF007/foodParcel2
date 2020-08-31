package com.foodparcel.Repository.impl;
/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.EmployeeRepository;
import com.foodparcel.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl employeeRepository = null;
    private Set<Employee> employeeDB;

    public EmployeeRepositoryImpl(){
        employeeDB = new HashSet<>();
    }

    public static EmployeeRepository employeeRepository(){
        if (employeeRepository == null)
            employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeDB;
    }

    @Override
    public Employee create(Employee employee) {
        this.employeeDB.add(employee);
        return employee;
    }

    @Override
    public Employee read(String empNumber) {
        Employee employee = this.employeeDB
                .stream()
                .filter(emp -> emp.getEmployeeNumber()
                        .trim()
                        .equalsIgnoreCase(empNumber))
                .findAny()
                .orElse(null);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = read(employee.getEmployeeNumber());
        if (oldEmployee != null){
            this.employeeDB.remove(oldEmployee);
            this.employeeDB.add(employee);
        }
        return employee;
    }

    @Override
    public void delete(String empNumber) {
        Employee employee = read(empNumber);

        if (employee != null){
            this.employeeDB.remove(employee);
        }
    }
}
