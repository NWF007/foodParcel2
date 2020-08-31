package com.foodparcel.Repository;

import com.foodparcel.entity.Donor;
import java.util.Set;

public interface DonorRepository extends IRepository <Donor, String> {
    Set<Donor> getAll();
}