package com.foodparcel.Service.impl;

import com.foodparcel.Repository.ProvinceRepository;
import com.foodparcel.Service.ProvinceService;
import com.foodparcel.entity.Province;
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
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository repository;

    @Override
    public Set<Province> getAll() {

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
    public Province create(Province province) {
        return this.repository.save(province);
    }

    @Override
    public Province read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Province update(Province province) {
        if(this.repository.existsById(province.getProvinceId())){

            return this.repository.save(province);
        }

        return null;
    }

    @Override
    public void delete(String s) {

    }
}
