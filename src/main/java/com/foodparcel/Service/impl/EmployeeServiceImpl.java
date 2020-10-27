package com.foodparcel.Service.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.EmployeeRepository;
import com.foodparcel.Service.EmployeeService;
import com.foodparcel.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.findById(s).orElseGet(null);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.deleteById(s);
    }
}
