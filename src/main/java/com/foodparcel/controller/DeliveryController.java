package com.foodparcel.controller;

import com.foodparcel.Service.DeliveryService;
import com.foodparcel.Service.impl.DeliveryServiceImpl;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Craig Bailey
 * 216178185
 */


@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl deliveryService;

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery){

        return deliveryService.create(delivery);
    }

    @GetMapping(path = "/find/{id}")
    public Delivery findById(@PathVariable String id){

        Delivery deliveries = deliveryService.read(id);
        return deliveries;
    }

    @PutMapping("/update")
    public void update(@RequestBody Delivery deliveries){

        deliveryService.update(deliveries);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        deliveryService.delete(id);
    }


    @GetMapping("/all")
    public Set<Delivery> getall(){
        return deliveryService.getAll();
    }


    }



