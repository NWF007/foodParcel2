package com.foodparcel.Service.impl;

import com.foodparcel.Service.EmployeeService;
import com.foodparcel.entity.Employee;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.EmployeeFactory;
import com.foodparcel.factory.JobFactory;
import com.foodparcel.util.IDGenerator;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    private static EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
    private static IDGenerator idGenerator = new IDGenerator();
    private static Job job = JobFactory.createJob("Manager");
    private static Employee employee = EmployeeFactory.createEmployee("123", "Niko", "Fortuin", "12/09/2020", job);

    @Test
    public void d_getAll() {
        Assert.assertNotNull(employeeService);
        System.out.println("Get all: " + employeeService.getAll());
    }

    @Test
    public void a_create() {
        Employee employeeCreate = employeeService.create(employee);
        Assert.assertSame(employee.getEmployeeNumber(), employeeCreate.getEmployeeNumber());
        System.out.println("Created: " +employeeCreate);
    }

    @Test
    public void b_read() {
        Employee employeeRead = employeeService.read(employee.getEmployeeNumber());
        Assert.assertNotNull(employeeRead);
        System.out.println("Read: " + employeeRead);
    }

    @Test
    public void c_update() {
        Employee  employeeUpdate = new Employee.EmployeeBuilder().copy(employee).setFirstName("Nico").build();
        employeeUpdate = employeeService.update(employeeUpdate);
        Assert.assertNotEquals(employee.getFirstName(), employeeUpdate.getFirstName());
        System.out.println("Updated: " +employeeUpdate);
    }

    @Test
    public void e_delete() {
        employeeService.delete(employee.getEmployeeNumber());
        Assert.assertNotNull(employeeService);
        System.out.println("Deleted: " +employeeService.getAll());
    }
}