package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryRepositoryImplTest {

    private DeliveryRepositoryImpl deliveryRepository;

    @Test
    public void create() {

        Delivery delivery = DeliveryFactory.getDelivery("Long Street", null);
        deliveryRepository.create(delivery);

        assertNotNull(deliveryRepository.getAll());
    }

    @Test
    public void read() {
        Delivery delivery = DeliveryFactory.getDelivery("Long Street", null);
        deliveryRepository.create(delivery);
        assertNotNull(deliveryRepository.getAll());
        Delivery from = deliveryRepository.read(delivery.getDeliveryID());
        assertEquals(delivery, from);
    }

    @Test
    public void update() {
        Delivery delivery = DeliveryFactory.getDelivery("Long street", null);
        deliveryRepository.create(delivery);
        assertNotNull(deliveryRepository.getAll());
        Delivery deliveryAddress = DeliveryFactory.getDelivery("Long Street", null);
        deliveryAddress.setDeliveryID(delivery.getDeliveryID());
        deliveryRepository.update(deliveryAddress);

        Delivery updated = deliveryRepository.read(deliveryAddress.getDeliveryID());
        assertEquals(deliveryAddress, updated);

    }

    @Test
    public void delete() {
        Delivery delivery = DeliveryFactory.getDelivery("Long Street", null);
        deliveryRepository.create(delivery);
        assertNotNull(deliveryRepository.getAll());
        deliveryRepository.delete(delivery.getDeliveryID());
        Delivery notThere = deliveryRepository.read(delivery.getDeliveryID());
        assertNull(notThere);

    }

}




