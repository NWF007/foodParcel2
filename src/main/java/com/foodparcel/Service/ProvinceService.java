package com.foodparcel.Service;

import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import java.util.Set;
/*
 * Mncedisi Mngadi
 * 214210286
 * 3B
 */


public interface ProvinceService extends IService<Province,String> {

        Set<Province> getAll();

        boolean delete1(String id);

        }
