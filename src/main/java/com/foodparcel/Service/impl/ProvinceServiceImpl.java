package com.foodparcel.Service.impl;

import com.foodparcel.Repository.ProvinceRepository;
import com.foodparcel.Repository.ProvinceRepositoryImpl;
import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Repository.VolunteerRepositoryImpl;
import com.foodparcel.Service.ProvinceService;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import org.springframework.stereotype.Service;

import java.util.Set;
/*
 * Mncedisi Mngadi
 * 214210286
 * 3B
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    private static ProvinceService service = null;
    private ProvinceRepository repository;

    private ProvinceServiceImpl(){

        this.repository = ProvinceRepositoryImpl.getRepository();
    }

    public static ProvinceService getService(){

        if(service == null) service = new ProvinceServiceImpl();
        return  service ;

    }

    @Override
    public Set<Province> getAll() {

        return this.repository.getAll();

    }

    @Override
    public boolean delete1(String id) {
        return this.repository.delete1(id);
    }

    @Override
    public Province create(Province province) {
        return this.repository.create(province);
    }

    @Override
    public Province read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Province update(Province province) {
        return this.repository.update(province);
    }

    @Override
    public void delete(String s) {

    }
}
