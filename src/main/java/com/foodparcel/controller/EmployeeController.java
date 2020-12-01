package com.foodparcel.controller;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.Service.impl.EmployeeServiceImpl;
import com.foodparcel.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping(path = "/find/{id}")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

    @GetMapping("/all")
    public Set<Employee> getAll(){
        return employeeService.getAll();
    }
}
