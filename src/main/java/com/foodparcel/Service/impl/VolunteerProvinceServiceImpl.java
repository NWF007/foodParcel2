package com.foodparcel.Service.impl;

import com.foodparcel.Repository.VolunteerProvinceRepository;
import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Service.VolunteerProvinceService;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.VolunteerProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VolunteerProvinceServiceImpl implements VolunteerProvinceService {

    @Autowired
    private VolunteerProvinceRepository repository;

    @Override
    public VolunteerProvince create(VolunteerProvince volunteerProvince) {
        return this.repository.save(volunteerProvince);
    }

    @Override
    public VolunteerProvince read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public VolunteerProvince update(VolunteerProvince volunteerProvince) {
        if(this.repository.existsById(volunteerProvince.getVolunteerNum())){

            return this.repository.save(volunteerProvince);
        }

        return null;
    }

    @Override
    public Set<VolunteerProvince> getAll() {
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
    public void delete(String s) {

    }
}
