package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;

public class DeliveryFactory {

    public static Delivery createDelivery(String deliveryAddress, String deliveryDate, String deliveryID, boolean Delivered) {

        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryID(deliveryID)
                .setDelivered(Delivered)
                .build();


        return delivery;

    }

    public static Delivery getDelivery(String long_street, Object o) {
        return null;
    }
}

