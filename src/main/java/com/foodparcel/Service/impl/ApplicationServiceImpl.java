/*Danielle Johnson
Student no: 214104281*/

package com.foodparcel.Service.impl;

import com.foodparcel.Repository.ApplicationRepository;
import com.foodparcel.Repository.impl.ApplicationRepositoryImpl;
import com.foodparcel.Service.ApplicationService;
import com.foodparcel.entity.Application;

import java.util.HashSet;
import java.util.Set;

public class ApplicationServiceImpl implements ApplicationService {
    private static ApplicationService service = null;
    private ApplicationRepository repository;

    private ApplicationServiceImpl(){
        this.repository = ApplicationRepositoryImpl.getRepository();
    }

    public static ApplicationService getService(){
        if(service==null)service= new ApplicationServiceImpl();
        return service;

    }

    @Override
    public Set<Application> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Application> applicationValuesThatAreEmpty() {
        Set<Application> applications = getAll();
        Set<Application> applicationEmptyValues = new HashSet<>();
        for(Application application :applications)
        {
            if(!application.getId().isEmpty() && !application.getFirstName().isEmpty() && !application.getLastName().isEmpty()
                    && !application.getHomeAdrress().isEmpty());
            {
                applicationEmptyValues.add(application);
            }
        }
        return applicationEmptyValues;
    }


    @Override
    public Application create(Application application) {
        return this.repository.create(application);
    }

    @Override
    public Application read(String serviceId) {
        return this.repository.read(serviceId);
    }

    @Override
    public Application update(Application application) {
        return this.repository.update(application);
    }


    @Override
    public void delete(String serviceId) {
        Application application = read(serviceId);
        if(application != null)
            this.repository.delete(serviceId);
    }

}
