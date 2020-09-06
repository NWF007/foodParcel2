package com.foodparcel.Service;

import com.foodparcel.entity.Inventory;

import java.util.Set;

public interface InventoryService extends IService <Inventory,Integer> {
    
    Set<Inventory> getAll();
    
}
