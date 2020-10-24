package com.foodparcel.Repository;

/**
 * Craig Bailey
 * 216178185
 */


import com.foodparcel.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {


    }


