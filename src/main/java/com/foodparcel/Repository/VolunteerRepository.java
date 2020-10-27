package com.foodparcel.Repository;
import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
//Mncedisi Mngadi
//214210286
@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer,String> {

    //Volunteer isAvailable(Volunteer t);

}
