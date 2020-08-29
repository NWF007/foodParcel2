package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;

public class DeliveryFactory {

    public static Delivery createDelivery (String deliveryAddress,String deliveryDate, Boolean Delivered) {
        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDelivered(Delivered)
                .build();


        return delivery;

    }
}