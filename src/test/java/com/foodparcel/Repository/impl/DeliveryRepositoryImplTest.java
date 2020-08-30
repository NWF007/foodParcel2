package com.foodparcel.Repository.impl;


import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryRepositoryImplTest {

    private static DeliveryRepository deliveryRepository = DeliveryRepositoryImpl.getDeliveryRepository();
    private static Delivery delivery = DeliveryFactory.createDelivery("Long Street", "28 August 2020", "1b324");


    public void d_getAll() {
        System.out.println("All Jobs: " + deliveryRepository.getAll());
        assertNotNull(delivery);
    }

    @Test
    public void a_create() {
        Delivery created = deliveryRepository.create(delivery);
        Assert.assertEquals(delivery.getDeliveryID(), created.getDeliveryID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Delivery delivery1 = deliveryRepository.read(delivery.getDeliveryID());
        assertNotNull(deliveryRepository.getAll());
        System.out.println("All the jobs: " + delivery1);
    }

    @Test
    public void c_update() {
        Delivery deliveryUpdate = new Delivery.Builder().copy(delivery).setDeliveryAddress("Long Street").setDeliveryDate("28 August 2020").build();
        deliveryUpdate = deliveryRepository.update(deliveryUpdate);
        assertNotEquals(delivery, deliveryUpdate);
        System.out.println(deliveryUpdate);
    }

    @Test
    public void e_delete() {
        deliveryRepository.delete(delivery.getDeliveryID());
        Delivery gone = deliveryRepository.read(delivery.getDeliveryID());
        assertNull(gone);
        System.out.println("Deleted!");

    }
}
