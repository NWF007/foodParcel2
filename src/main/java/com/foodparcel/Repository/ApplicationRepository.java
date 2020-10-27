//Danielle Johnson
//Student no: 214104281

package com.foodparcel.Repository;

import com.foodparcel.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {

}
