package com.foodparcel.Service.impl;

import com.foodparcel.Repository.DeliveryRepository;
import com.foodparcel.Service.DeliveryService;
import com.foodparcel.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Craig Bailey
 * 216178185
 */

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;


    @Override
    public Set<Delivery> getAll() {
        return this.deliveryRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Delivery create(Delivery delivery) {
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public Delivery read(String s) {
        return this.deliveryRepository.findById(s).orElseGet(null);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public void delete(String s) {
        this.deliveryRepository.deleteById(s);



    }
}
