package com.foodparcel.Repository.impl;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Repository.EmployeeRepository;
import com.foodparcel.entity.Employee;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.EmployeeFactory;
import com.foodparcel.factory.JobFactory;
import com.foodparcel.util.IDGenerator;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {
    private static EmployeeRepository employeeRepository = EmployeeRepositoryImpl.employeeRepository();
    private static IDGenerator idGenerator = new IDGenerator();
    private static Job job = JobFactory.createJob("Accountant");
    private static Employee employee = EmployeeFactory.createEmployee(idGenerator.generateId(),"111", "Niko", "Fortuin", "12/08/2020", job);

    @Test
    public void d_getAll() {
        Assert.assertNotNull(employeeRepository);
        System.out.println("Get all: " + employeeRepository.getAll());
    }

    @Test
    public void a_create() {
        Employee createEmployee = employeeRepository.create(employee);
        Assert.assertEquals(employee.getEmployeeNumber(), createEmployee.getEmployeeNumber());
        System.out.println("Created: " + createEmployee);
    }

    @Test
    public void b_read() {
        Employee readEmployee = employeeRepository.read(employee.getEmployeeNumber());
        Assert.assertNotNull(readEmployee);
        System.out.println("Read: " + readEmployee);
    }

    @Test
    public void c_update() {
        Employee updateEmployee = new Employee.EmployeeBuilder().copy(employee).setFirstName("Nico").build();
        updateEmployee = employeeRepository.update(updateEmployee);
        Assert.assertNotEquals(employee, updateEmployee);
        System.out.println("Update: " + updateEmployee);
    }

    @Test
    public void e_delete() {
        employeeRepository.delete(employee.getEmployeeNumber());
        Assert.assertNotNull(employeeRepository);
        System.out.println("Deleted: " + employeeRepository.getAll());
    }
}