package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.VolunteerProvinceRepository;
import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;

import java.util.HashSet;
import java.util.Set;

public class VolunteerProvinceRepositoryImpl implements VolunteerProvinceRepository {

    private static VolunteerProvinceRepository repository = null;
    private Set<VolunteerProvince> VolunteerProvincesDB;

    private VolunteerProvinceRepositoryImpl(){
        this.VolunteerProvincesDB = new HashSet<>();
    }

    public static VolunteerProvinceRepository getRepository(){

        if(repository == null) repository = new VolunteerProvinceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<VolunteerProvince> getAll() {
        return this.VolunteerProvincesDB;
    }


    @Override
    public VolunteerProvince create(VolunteerProvince volunteerProvince) {
        this.VolunteerProvincesDB.add(volunteerProvince);
        return volunteerProvince;
    }

    @Override
    public VolunteerProvince read(String s) {
        for (VolunteerProvince volunteerProvince : this.VolunteerProvincesDB){

            if (volunteerProvince.getVolunteerNum().equals(s)) return volunteerProvince;

        }

        return null;
    }

    @Override
    public VolunteerProvince update(VolunteerProvince volunteerProvince) {
        VolunteerProvince oldVolunteerProvince = read(volunteerProvince.getVolunteerNum());

        if(oldVolunteerProvince !=null){

            this.VolunteerProvincesDB.remove(oldVolunteerProvince);
            this.VolunteerProvincesDB.add(volunteerProvince);

        }
        return volunteerProvince;
    }


    @Override
    public boolean delete1(String id) {
        VolunteerProvince volunteerProvince = read(id);

        if (volunteerProvince !=null){

            this.VolunteerProvincesDB.remove(volunteerProvince);
            return true;
        }

        return false;
    }

    @Override
    public void delete(String s) {

    }
}
