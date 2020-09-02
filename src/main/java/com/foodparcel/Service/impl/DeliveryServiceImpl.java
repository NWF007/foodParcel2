package com.foodparcel.Service.impl;

import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.Repository.impl.DeliveryRepositoryImpl;
import com.foodparcel.Service.DeliveryService;
import com.foodparcel.entity.Delivery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Craig Bailey
 * 216178185
 */


public class DeliveryServiceImpl implements DeliveryService {

    private static DeliveryService service = null;
    private DeliveryRepository deliveryRepository;

    private DeliveryServiceImpl(){
        this.deliveryRepository = DeliveryRepositoryImpl.getDeliveryRepository();

    }

    public static DeliveryService getService(){
        if (service == null) service = new DeliveryServiceImpl();
        return service;
    }



    @Override
    public Set<Delivery> getAll() {
        return this.deliveryRepository.getAll();
    }

    @Override
    public Delivery create(Delivery delivery) {
        return this.deliveryRepository.create(delivery);
    }

    @Override
    public Delivery read(String s) {
        return this.deliveryRepository.read(s);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return this.deliveryRepository.update(delivery);
    }

    @Override
    public void delete(String s) {
        this.deliveryRepository.delete(s);

    }
}
