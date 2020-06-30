package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryFactoryTest {

    @Test
    public void getDeliveryAddress() {

        Delivery delivery = DeliveryFactory.getDeliveryAddress("Cape Town");
        Assert.assertEquals(null, delivery.getDeliveryDate());

    }
}