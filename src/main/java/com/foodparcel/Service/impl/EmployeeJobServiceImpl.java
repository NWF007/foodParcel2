package com.foodparcel.Service.impl;

import com.foodparcel.Repository.EmployeeJobRepository;
import com.foodparcel.entity.EmployeeJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeJobServiceImpl {

    @Autowired
    private EmployeeJobRepository employeeJobRepository;

    public Set<EmployeeJob> getAll(){
        return this.employeeJobRepository.findAll().stream().collect(Collectors.toSet());
    }

    public EmployeeJob create(EmployeeJob employeeJob){
        return this.employeeJobRepository.save(employeeJob);
    }

    public EmployeeJob read(String s) {
        return this.employeeJobRepository.findById(s).orElseGet(null);
    }

    public EmployeeJob update(EmployeeJob employeeJob){
        return this.employeeJobRepository.save(employeeJob);
    }

    public void delete(String s) {
        this.employeeJobRepository.deleteById(s);
    }

}
