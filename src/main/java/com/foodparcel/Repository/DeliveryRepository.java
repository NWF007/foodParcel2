package com.foodparcel.Repository;

import com.foodparcel.Repository.impl.Repository;
import com.foodparcel.entity.Delivery;

import java.util.Set;



    public interface DeliveryRepository extends Repository<Delivery, String> {

        Set<Delivery> getAll();

    }

