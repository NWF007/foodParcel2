package com.foodparcel.controller;

import com.foodparcel.Service.impl.DeliveryServiceImpl;
import com.foodparcel.entity.Delivery;
import com.foodparcel.factory.DeliveryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
    Craig Bailey
    216178185
 */

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl deliveryService;

    @PostMapping("/create")
    public Delivery create (@RequestBody Delivery delivery){
        Delivery newDelivery = DeliveryFactory.createDelivery(delivery.getDeliveryAddress(), delivery.getDeliveryDate());
        return deliveryService.create(newDelivery);
    }

    @GetMapping(path ="/read/{id}")
    public Delivery read(@PathVariable String id){

        return deliveryService.read(id);
    }

    @PutMapping("/update")
    public void update(Delivery delivery){

        deliveryService.update(delivery);
    }

    @GetMapping("/all")
    public Set<Delivery> getall(){
        return deliveryService.getAll();

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){

        this.deliveryService.delete(id);
    }


}



