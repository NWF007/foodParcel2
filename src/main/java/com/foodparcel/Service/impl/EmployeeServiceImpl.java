package com.foodparcel.Service.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.EmployeeRepository;
import com.foodparcel.Repository.impl.EmployeeRepositoryImpl;
import com.foodparcel.Service.EmployeeService;
import com.foodparcel.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService employeeService = null;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(){
        this.employeeRepository = EmployeeRepositoryImpl.employeeRepository();
    }

    public static EmployeeService getEmployeeService() {
        if (employeeService == null) employeeService = new EmployeeServiceImpl();
        return employeeService;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.getAll();
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }
}
