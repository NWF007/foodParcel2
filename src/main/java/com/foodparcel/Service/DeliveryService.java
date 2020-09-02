package com.foodparcel.Service;

/**Craig Bailey
 * 2167178185djd
 */

import com.foodparcel.entity.Delivery;

import java.util.Set;



public interface DeliveryService extends IService <Delivery, String> {

    Set<Delivery> getAll();


}

