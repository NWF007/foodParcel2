/*Danielle Johnson
Student no: 214104281*/

package com.foodparcel.Service.impl;

import com.foodparcel.Repository.ApplicationRepository;
import com.foodparcel.Service.ApplicationService;
import com.foodparcel.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository repository;


    @Override
    public Set<Application> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Application> noEmptyValues() {
        Set<Application> applications = getAll();
        Set<Application> applicationEmptyValues = new HashSet<>();
        for(Application application :applications)
        {
            if(!application.getId().isEmpty() && !application.getFirstName().isEmpty() &&
                    !application.getLastName().isEmpty());
            {
                applicationEmptyValues.add(application);
            }
        }
        return applicationEmptyValues;
    }


    @Override
    public Application create(Application application) {
        return this.repository.save(application);
    }

    @Override
    public Application read(String serviceId) {
        return this.repository.findById(serviceId).orElseGet(null);
    }

    @Override
    public Application update(Application application) {
        return this.repository.save(application);
    }


    @Override
    public void delete(String serviceId) {
        Application application = read(serviceId);
        if(application != null)
            this.repository.deleteById(serviceId);
    }

}
