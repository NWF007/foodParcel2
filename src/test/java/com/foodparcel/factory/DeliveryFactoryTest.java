
package com.foodparcel.factory;
import com.foodparcel.entity.Delivery;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class DeliveryFactoryTest {

    @Test
    public void createDelivery() {

        Boolean Yes = null;

        Delivery delivery = DeliveryFactory.createDelivery("Cape Town", "28 August 2020", "1b324");
        System.out.println(delivery);
        Assert.assertEquals("1b324", delivery.getDeliveryID());
        Assert.assertNotNull(delivery);
        Assert.assertNotEquals(UUID.randomUUID().toString(), delivery.getDeliveryID());




    }
}
