//Danielle Johnson
//Student no: 214104281

package com.foodparcel.Repository;

import com.foodparcel.entity.Application;

import java.util.Set;

public interface ApplicationRepository extends IRepository<Application, String>{
    Set<Application> getAll();
}
