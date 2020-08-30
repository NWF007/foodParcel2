package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;
<<<<<<< HEAD
import com.foodparcel.util.IDGenerator;

public class DeliveryFactory {

    public static Delivery createDelivery (String deliveryAddress , String deliveryDate , String deliveryID) {

        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDeliveryID(IDGenerator.generateId())
=======

public class DeliveryFactory {

    public static Delivery createDelivery (String deliveryAddress,String deliveryDate, Boolean Delivered) {
        Delivery delivery = new Delivery.Builder()
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryDate(deliveryDate)
                .setDelivered(Delivered)
>>>>>>> fa981789147286f0246885eb07d61397839685d1
                .build();


        return delivery;

    }
<<<<<<< HEAD


    public static Delivery getDelivery(String long_street, Object o) {
        return null;
    }
}

=======
}
>>>>>>> fa981789147286f0246885eb07d61397839685d1
