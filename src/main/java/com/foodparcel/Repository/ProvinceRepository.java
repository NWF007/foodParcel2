package com.foodparcel.Repository;

import com.foodparcel.entity.Province;

import java.util.Set;
//Mncedisi Mngadi
//214210286
public interface ProvinceRepository extends IRepository<Province, String> {

    Set<Province> getAll();
    boolean delete1(String id);

}
