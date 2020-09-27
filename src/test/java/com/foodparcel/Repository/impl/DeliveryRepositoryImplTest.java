package com.foodparcel.Repository.impl;

/**
 * Craig Bailey
 * 216178185
 */



import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import com.foodparcel.Repository.DeliveryRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryRepositoryImplTest {

    private static DeliveryRepository deliveryRepository = DeliveryRepositoryImpl.getDeliveryRepository();
    private static Delivery delivery = DeliveryFactory.createDelivery("Long Street", "28 August 2020");


    public void d_getAll() {
        System.out.println("All Deliveries: " + deliveryRepository.getAll());
        Assert.assertNotNull(deliveryRepository);
    }
    @Test
    public void a_create() {
        Delivery created = deliveryRepository.create(delivery);
        Assert.assertEquals(delivery.getDeliveryID(), created.getDeliveryID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Delivery read = deliveryRepository.create(delivery);
        System.out.println("Read: " + read);
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
        Assert.assertNotNull(deliveryRepository);
        System.out.println("Deleted: " + deliveryRepository.getAll());
    }
}

