package com.foodparcel.controller;

import com.foodparcel.Service.impl.EmployeeJobServiceImpl;
import com.foodparcel.entity.EmployeeJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employeejob")
public class EmployeeJobController {

    @Autowired
    private EmployeeJobServiceImpl employeeJobService;

    @PostMapping("/create")
    public EmployeeJob create(@RequestBody EmployeeJob employeeJob){
        return employeeJobService.create(employeeJob);
    }

    @GetMapping("/read/{id}")
    public EmployeeJob read(@PathVariable String id){
        return employeeJobService.read(id);
    }

    @PutMapping("/update")
    public void update(EmployeeJob employeeJob){
        employeeJobService.update(employeeJob);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        employeeJobService.delete(id);
    }

    @GetMapping("/all")
    public Set<EmployeeJob> getAll(){
        return employeeJobService.getAll();
    }

}
