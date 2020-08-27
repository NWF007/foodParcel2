package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;

public class DeliveryFactory {

    public static Delivery createDelivery(String deliveryAddress, String deliveryDate, String deliveryID, Boolean Delivered) {

        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryID(deliveryID)
                .setDelivered(delivered)
                .build();


        return delivery;

    }

    public static Delivery getDelivery(String long_street, Object o) {
        return null;
    }
}

