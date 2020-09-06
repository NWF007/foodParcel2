package com.foodparcel.Service.impl;

import com.foodparcel.Repository.InventoryRepository;
import com.foodparcel.Repository.impl.InventoryRepositoryImpl;
import com.foodparcel.Service.InventoryService;
import com.foodparcel.entity.Inventory;

import java.util.Set;

public class InventoryServiceImpl implements InventoryService {
    
    private static InventoryService service = null;
    private InventoryRepository inventoryRepository;
    
    private InventoryServiceImpl(){
        this.inventoryRepository = InventoryRepositoryImpl.inventoryRepository();
    }
    
    public static InventoryService getService(){
        if (service == null) service = new InventoryServiceImpl();
        return service;
    }
    
    
    @Override
    public Set<Inventory> getAll() {
        return this.inventoryRepository.getAll();
    }

    @Override
    public Inventory create(Inventory inventory) {
        return this.inventoryRepository.create(inventory);
    }

    @Override
    public Inventory read(Integer s) {
        return this.inventoryRepository.read(s);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return this.inventoryRepository.update(inventory);
    }

    @Override
    public void delete(Integer s) {
        this.inventoryRepository.delete(s);
    }
}
