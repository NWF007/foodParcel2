<<<<<<< HEAD
/*
=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
package com.foodparcel.factory;

import com.foodparcel.entity.Delivery;
import org.junit.Assert;
import org.junit.Test;

<<<<<<< HEAD
import java.util.UUID;

=======
>>>>>>> fa981789147286f0246885eb07d61397839685d1
import static org.junit.Assert.*;

public class DeliveryFactoryTest {

    @Test
    public void createDelivery() {

<<<<<<< HEAD
        Boolean Yes = null;

        Delivery delivery = DeliveryFactory.createDelivery("Cape Town", "28 August 2020", "1b324");
        System.out.println(delivery);
        Assert.assertEquals("1b324", delivery.getDeliveryID());
        Assert.assertNotNull(delivery);
        Assert.assertNotEquals(UUID.randomUUID().toString(), delivery.getDeliveryID());




    }
}*/
=======

        Boolean Yes = null;
        Delivery delivery;
        delivery = DeliveryFactory.createDelivery("Cape Town", "28 June 2020", Yes);
        Assert.assertEquals("testDeliveryDate", delivery.getDeliveryAddress());

    }
}
>>>>>>> fa981789147286f0246885eb07d61397839685d1
