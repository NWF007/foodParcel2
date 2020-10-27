package com.foodparcel.Service;

import com.foodparcel.entity.EmployeeJob;

import java.util.Set;

public interface EmployeeJobService extends IService<EmployeeJob, String> {
    Set<EmployeeJob> getAll();
}
