package com.foodparcel.Repository.impl;

/**Craig Bailey
 * 216178185
 */

import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.entity.Delivery;
import java.util.HashSet;
import java.util.Set;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    private static DeliveryRepositoryImpl deliveryRepository = null;
    private Set<Delivery> deliveries;


    public DeliveryRepositoryImpl() {
        deliveries = new HashSet<>();
    }

    public static DeliveryRepository getDeliveryRepository() {

        if (deliveryRepository == null) {
            deliveryRepository = new DeliveryRepositoryImpl();

            return deliveryRepository;

        }

        return null;
    }

    public Set<Delivery> getAll () {
        return this.deliveries;
    }


    public Delivery create (Delivery delivery){
        this.deliveries.add(delivery);
        return delivery;
    }

    public Delivery read (String deliveryID){

        Delivery delivery = this.deliveries
                .stream()
                .filter(deliveries1 -> deliveries1.getDeliveryID()
                .trim()
                .equalsIgnoreCase(deliveryID))
                .findAny()
                .orElse(null);
        return delivery;


    }

    public Delivery update (Delivery delivery){

        Delivery oldDelivery = read(delivery.getDeliveryID());
        if (oldDelivery!= null) {
            this.deliveries.remove(oldDelivery);
            this.deliveries.add(delivery);
        }

        return delivery;
    }

    @Override
    public void delete (String ID){

        String deliveryID = null;
        Delivery delivery = read(deliveryID);

        if (delivery != null) {
            deliveries.remove(delivery);

        }


    }

}