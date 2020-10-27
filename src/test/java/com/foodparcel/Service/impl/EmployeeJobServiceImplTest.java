package com.foodparcel.Service.impl;

import com.foodparcel.Service.EmployeeJobService;
import com.foodparcel.entity.EmployeeJob;
import com.foodparcel.factory.EmployeeJobFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeJobServiceImplTest {

    @Autowired
    private static EmployeeJobService employeeJobService;
    private static EmployeeJob employeeJob = EmployeeJobFactory.create("", "");

    @Test
    public void d_getAll() {
        Assert.assertNotNull(employeeJobService);
        System.out.println("Get all: " +employeeJobService.getAll());
    }

    @Test
    public void a_create() {
        EmployeeJob createEmployeeJob = employeeJobService.create(employeeJob);
        Assert.assertSame(employeeJob.getEmployeeNumber(), createEmployeeJob.getEmployeeNumber());
        System.out.println("Create: " +createEmployeeJob);
    }

    @Test
    public void b_read() {
        EmployeeJob employeeJobRead = employeeJobService.read(employeeJob.getEmployeeNumber());
        Assert.assertNotNull(employeeJobRead);
        System.out.println("Read: " +employeeJobRead);
    }

    @Test
    public void c_update() {
        EmployeeJob employeeJobUpdate = new EmployeeJob.Builder().copy(employeeJob).setJobNumber("new").build();
        employeeJobUpdate = employeeJobService.update(employeeJobUpdate);
        Assert.assertNotEquals(employeeJob, employeeJobUpdate);
        System.out.println("Update: "+employeeJobUpdate);
    }

    @Test
    public void e_delete() {
        employeeJobService.delete(employeeJob.getEmployeeNumber());
        Assert.assertNotNull(employeeJob);
        System.out.println("Deleted: " +employeeJobService.getAll());
    }
}