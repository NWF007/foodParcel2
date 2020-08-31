package com.foodparcel.Repository.impl;
import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.entity.Delivery;
import java.util.HashSet;
import java.util.Set;
import static javax.swing.text.html.parser.DTDConstants.ID;



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
        return deliveries;
    }


    public Delivery create (Delivery delivery){
        deliveries.add(delivery);
        return delivery;
    }

    public Delivery read (String ID){


        return deliveries.stream().filter(delivery -> delivery.getDeliveryID().equals(ID)).findAny().orElse(null);
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
