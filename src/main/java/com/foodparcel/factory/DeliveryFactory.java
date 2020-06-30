package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;

public class DeliveryFactory {

    public static Delivery getDeliveryAddress(String deliveryAddress) {

        return new Delivery.Builder().setDeliveryAddress(deliveryAddress).build();

    }
}