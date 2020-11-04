package com.foodparcel.Repository;

import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;
@Repository
public interface VolunteerProvinceRepository extends JpaRepository<VolunteerProvince,String> {



}
