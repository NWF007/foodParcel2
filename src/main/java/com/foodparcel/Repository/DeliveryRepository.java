package com.foodparcel.Repository;

import com.foodparcel.entity.Delivery;

import java.util.Set;



    public interface DeliveryRepository extends IRepository<Delivery, String> {

        Set<Delivery> getAll();

    }

