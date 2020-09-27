//Danielle Johnson
//Student no: 214104281

package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.ApplicationRepository;
import com.foodparcel.entity.Application;

import java.util.HashSet;
import java.util.Set;


public class ApplicationRepositoryImpl implements ApplicationRepository {

    private static ApplicationRepository repository = null;
    private Set<Application> appDB;

    public ApplicationRepositoryImpl(){this.appDB=new HashSet<>();}

    public static ApplicationRepository getRepository(){
        if(repository==null)repository= new ApplicationRepositoryImpl();
        return repository;

    }


    @Override
    public Application create(Application application) {
        this.appDB.add(application);
        return application;
    }

    @Override
    public Application read(String applicationID) {

        for (Application application : this.appDB) {
            if(application.getId().equals(applicationID))return  application;
        }
        return null;
    }

    @Override
    public Application update(Application application) {
        Application oldApplicationID = read(application.getId());
        if(oldApplicationID != null){
            this.appDB.remove(oldApplicationID);
            this.appDB.add(application);
        }
        return application;
    }


    @Override
    public void delete(String applicationID) {
        Application application = read(applicationID);
        if(application != null)
            this.appDB.remove(application);

    }
    @Override
    public Set<Application> getAll() {
        return this.appDB;
    }
}


