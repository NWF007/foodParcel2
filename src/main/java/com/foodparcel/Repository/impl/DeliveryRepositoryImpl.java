package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.entity.Delivery;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.*;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository{

    private static DeliveryRepositoryImpl deliveryRepository = null;
    private Set <Delivery> deliveryAddress;

    public DeliveryRepositoryImpl(){
        deliveryAddress = new HashSet<>();
    }

    public static DeliveryRepositoryImpl getDeliveryRepository(){

        if(deliveryRepository == null){
            return new DeliveryRepositoryImpl();
        }

        return deliveryRepository;
    }


    public Delivery create (Delivery delivery){
        deliveryAddress.add(delivery);
        return delivery;
    }

    public Delivery read( String ID){


        return deliveryAddress.stream().filter(delivery -> delivery.getDeliveryID().equals(ID)).findAny().orElse(null);

        }

        public Delivery update(Delivery delivery){

            Delivery inDB = read(delivery.getDeliveryID());
            if( inDB != null){
                deliveryAddress.remove(inDB);
                deliveryAddress.add(delivery);
                return delivery;
            }

            return null;

        }


        public void delete(String id) {

            Delivery inDB = read(id);
            deliveryAddress.remove(inDB);

        }


        public Set<Delivery> getAll() {
            return deliveryAddress;
        }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}






