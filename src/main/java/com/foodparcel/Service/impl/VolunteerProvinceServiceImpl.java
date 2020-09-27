package com.foodparcel.Service.impl;

import com.foodparcel.Repository.VolunteerProvinceRepository;
import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Repository.VolunteerRepositoryImpl;
import com.foodparcel.Repository.impl.VolunteerProvinceRepositoryImpl;
import com.foodparcel.Service.VolunteerProvinceService;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.VolunteerProvince;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VolunteerProvinceServiceImpl implements VolunteerProvinceService {

    private static VolunteerProvinceService service = null;
    private VolunteerProvinceRepository repository;

    private VolunteerProvinceServiceImpl(){

        this.repository = VolunteerProvinceRepositoryImpl.getRepository();
    }

    public static VolunteerProvinceService getService(){

        if(service == null) service = new VolunteerProvinceServiceImpl();
        return  service ;

    }

    @Override
    public VolunteerProvince create(VolunteerProvince volunteerProvince) {
        return this.repository.create(volunteerProvince);
    }

    @Override
    public VolunteerProvince read(String s) {
        return this.repository.read(s);
    }

    @Override
    public VolunteerProvince update(VolunteerProvince volunteerProvince) {
        return this.repository.update(volunteerProvince);
    }

    @Override
    public Set<VolunteerProvince> getAll() {
        return this.repository.getAll();
    }

    @Override
    public boolean delete1(String id) {
        return this.repository.delete1(id);
    }

    @Override
    public void delete(String s) {

    }
}
