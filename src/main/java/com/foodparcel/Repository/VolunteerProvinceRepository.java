package com.foodparcel.Repository;

import com.foodparcel.entity.VolunteerProvince;


import java.util.Set;

public interface VolunteerProvinceRepository extends IRepository<VolunteerProvince, String> {

    Set<VolunteerProvince> getAll();
    boolean delete1(String id);

}
