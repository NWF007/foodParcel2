package com.foodparcel.Service;

import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;

import java.util.Set;

public interface VolunteerProvinceService extends IService<VolunteerProvince,String> {

    Set<VolunteerProvince> getAll();

    boolean delete1(String id);

}
