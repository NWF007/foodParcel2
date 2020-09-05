package com.foodparcel.Service;

import com.foodparcel.entity.Volunteer;
import java.util.Set;

/*
 * Mncedisi Mngadi
 * 214210286
 * 3B
 */


public interface VolunteerService extends IService<Volunteer,String> {

    Set<Volunteer> getAll();

    boolean delete1(String id);

}
