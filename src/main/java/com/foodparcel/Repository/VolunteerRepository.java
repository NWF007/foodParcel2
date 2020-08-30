package com.foodparcel.Repository;
import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import java.util.Set;
//Mncedisi Mngadi
//214210286

public interface VolunteerRepository extends IRepository<Volunteer,String> {

    Set<Volunteer> getAll();

    boolean delete1(String id);

}
