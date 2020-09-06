package com.foodparcel.Repository;

import com.foodparcel.entity.Inventory;

import java.util.Set;

public interface InventoryRepository extends IRepository<Inventory, Integer> {
    
    Set<Inventory> getAll();
}
