package com.foodparcel.Service.impl;

/**Craig Bailey
 * 216178185
 */

import com.foodparcel.Service.DeliveryService;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryServiceImplTest {

    private static DeliveryService service = DeliveryServiceImpl.getService();
    private static Delivery delivery = DeliveryFactory.createDelivery("Long Street", "28 August");

    @Test
    public void d_getAll() {

        Assert.assertNotNull(service);
        System.out.println("Get all: " + service.getAll());
    }

    @Test
    public void a_create() {

        Delivery created = service.create(delivery);
        Assert.assertEquals(delivery.getDeliveryID(), created.getDeliveryID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Delivery read = service.create(delivery);
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        Delivery updated = new Delivery.Builder().copy(delivery).setDeliveryAddress("Long Street").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        service.delete(delivery.getDeliveryID());
        Assert.assertNotNull(service);
        System.out.println("Deleted: " + service.getAll());
    }
}