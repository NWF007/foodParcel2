package com.foodparcel.controller;

import com.foodparcel.Service.impl.ApplicationServiceImpl;
import com.foodparcel.entity.Application;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.ApplicationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired

    private ApplicationServiceImpl applicationService;

    @PostMapping("/create")
    public Application create(@RequestBody Application application) {
        Application controllerApplication = ApplicationFactory.createApplication(application.getId(),
                application.getFirstName(),application.getLastName(),application.getHomeAddress(),
                application.getContactNumber(),application.getNumberOfDependants(),application.getIncome());
        return applicationService.create(controllerApplication);

    }

    @GetMapping("/read/{id}")
    public Application read(@PathVariable String id){
        return applicationService.read(id);
    }

    @PostMapping("/update")
    public Application update(@RequestBody Application application){
        return applicationService.update(application);
    }

    @GetMapping("/getApplications")
    public Set<Application> getApp(){
        return applicationService.getAll();
    }

    @GetMapping("/applicationValuesThatAreNotEmpty")
    public Set<Application> getValues(){
        return  applicationService.noEmptyValues();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){

        applicationService.delete(id);
    }




}
