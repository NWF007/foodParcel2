package com.foodparcel.factory;


/**
 * Craig Bailey
 * 216178185
 */


import com.foodparcel.entity.Delivery;
import com.foodparcel.util.IDGenerator;

public class DeliveryFactory {


    public static Delivery createDelivery(String deliveryAddress, String deliveryDate) {

        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryID(IDGenerator.generateId())
                .build();
        return delivery;

    }
}