package com.foodparcel.Service.impl;

import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Repository.VolunteerRepositoryImpl;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
/*
* Mncedisi Mngadi
* 214210286
* 3B
 */

@Service
public class VolunteerServiceImpl implements VolunteerService {

    private static VolunteerService service = null;
    private VolunteerRepository repository;


    private VolunteerServiceImpl(){

        this.repository = VolunteerRepositoryImpl.getRepository();
    }

    public static VolunteerService getService(){

        if(service == null) service = new VolunteerServiceImpl();
        return  service ;

    }

    @Override
    public Set<Volunteer> getAll() {

        return this.repository.getAll();

    }

    @Override
    public boolean delete1(String id) {
        return this.repository.delete1(id);
    }

    @Override
    public Volunteer isAvailable(Volunteer t) {
        return this.repository.isAvailable(t);
    }

    @Override
    public Volunteer create(Volunteer volunteer) {
        return this.repository.create(volunteer);
    }

    @Override
    public Volunteer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Volunteer update(Volunteer volunteer) {
        return this.repository.update(volunteer);
    }

    @Override
    public void delete(String s) {

    }
}
