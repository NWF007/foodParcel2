package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.InventoryRepository;
import com.foodparcel.entity.Inventory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class InventoryRepositoryImpl implements InventoryRepository {
    
    private static InventoryRepository inventoryRepository = null;
    private Set<Inventory> inventories;
    
    public InventoryRepositoryImpl(){
        inventories = new HashSet<>();
    }
    
    public static InventoryRepository inventoryRepository(){
        if (inventoryRepository == null)
            inventoryRepository = new InventoryRepositoryImpl();
        return inventoryRepository;
    }
    
    @Override
    public Set <Inventory> getAll(){
        return this.inventories;
    }
    
    @Override
    public Inventory create(Inventory inventory){
        this.inventories.add(inventory);
        return inventory;
    }

    @Override
    public Inventory read(Integer integer) {
        return null;
    }

  

    public Inventory read(int parcelsInStock){
        Inventory inventory = this.inventories
                .stream()
                .filter(in -> Objects.equals(in.getParcelsInStock(), parcelsInStock))
                .findAny()
                .orElse(null);
        return inventory;
    }
    public Inventory update(Inventory inventory){
        Inventory oldInventory = read(inventory.getParcelsInStock());
        if(oldInventory != null){
            this.inventories.remove(oldInventory);
            this.inventories.add(inventory);
        }
        return inventory;
    }

    @Override
    public void delete(Integer integer) {

    }

  

    public void delete(int parcelsInStock){
        Inventory inventory = read(parcelsInStock);
        
        if(inventory != null){
            this.inventories.remove(inventory);
        }
        
    }
}
