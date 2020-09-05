/*Danielle Johnson
Student no: 214104281*/
package com.foodparcel.Service;

import com.foodparcel.entity.Application;

import java.util.Set;

public interface ApplicationService extends IService<Application, String> {
    Set<Application> getAll();

    Set<Application> applicationValuesThatAreEmpty();
}

