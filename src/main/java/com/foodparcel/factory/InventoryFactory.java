package com.foodparcel.factory;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Inventory;

public class InventoryFactory {

    public static Inventory createInventory(int parcelsInStock){
        return new Inventory.InventoryBuilder()
                .setParcelsInStock(parcelsInStock)
                .build();
    }
}
