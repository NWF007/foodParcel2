package com.foodparcel.Service.impl;

import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
/*
* Mncedisi Mngadi
* 214210286
* 3B
 */

@Service
public class VolunteerServiceImpl implements VolunteerService {


    @Autowired
    private VolunteerRepository repository;


    @Override
    public Set<Volunteer> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());

    }

    @Override
    public boolean delete1(String id) {

        this.repository.deleteById(id);

        if(this.repository.existsById(id)){

            return false;

        }

        return true;

    }

    @Override
    public Volunteer isAvailable(Volunteer t) {
       return this.repository.save(t);//This method is for the Volunteer's availability status
  }

    @Override
    public Volunteer create(Volunteer volunteer) {
        return this.repository.save(volunteer);
    }

    @Override
    public Volunteer read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Volunteer update(Volunteer volunteer) {

        if(this.repository.existsById(volunteer.getVolunteerNum())){

            return this.repository.save(volunteer);
        }

        return null;

    }

    @Override
    public void delete(String s) {

    }
}
