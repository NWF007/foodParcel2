package com.foodparcel.controller;

import com.foodparcel.Service.impl.EmployeeServiceImpl;
import com.foodparcel.entity.Employee;
import com.foodparcel.factory.EmployeeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        //Employee newEmployee = EmployeeFactory.createEmployee(employee.getIdentityNumber(),employee.getFirstName(),employee.getLastName(), employee.getEmploymentDate(), employee.getJobTitle());
        return employeeService.create(employee);
    }

    @GetMapping(path = "/find/{id}")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PutMapping("/update")
    public void update(Employee employee) {
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
