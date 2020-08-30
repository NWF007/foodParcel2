package com.foodparcel.Repository;

/**
 * Craig Bailey
 * 216178185
 */

import com.foodparcel.entity.Delivery;

import java.util.Set;


public interface DeliveryRepository extends IRepository<Delivery, String> {

    Set<Delivery> getAll();

}