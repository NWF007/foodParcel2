package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.InventoryRepository;
import com.foodparcel.entity.Inventory;
import com.foodparcel.factory.InventoryFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryRepositoryImplTest {
    
    private static InventoryRepository inventoryRepository = InventoryRepositoryImpl.inventoryRepository();
    private static Inventory inventory = InventoryFactory.createInventory(10);
    
    public void d_getAll(){
        Assert.assertNotNull(inventoryRepository);
        System.out.println("Get all: " +inventoryRepository.getAll());
       
    }
    
    @Test
    public void a_create(){
        Inventory created = inventoryRepository.create(inventory);
        Assert.assertEquals(inventory.getParcelsInStock(),created.getParcelsInStock());
        System.out.println("Created: " + created);
    }
    @Test
    public void b_read(){
        /*Inventory readInventory = inventoryRepository.read(inventory.getParcelsInStock());
        Assert.assertNotNull(inventoryRepository.getAll());
        System.out.println("Read: " + readInventory);*/
      
        Inventory read = inventoryRepository.create(inventory);
        System.out.println("Read: " + read);
        
    }
    
    @Test
    public void c_update(){
        Inventory inventoryUpdate = new Inventory.InventoryBuilder().copy(inventory).setParcelsInStock(10).build();
        inventoryUpdate = inventoryRepository.update(inventoryUpdate);
        assertNotEquals(inventory,inventoryUpdate);
        System.out.println(inventoryUpdate);
    }
    
    @Test
    public void e_delete(){
        inventoryRepository.delete(inventory.getParcelsInStock());
        Assert.assertNotNull(inventoryRepository);
        System.out.println("Deleted: " +inventoryRepository.getAll());
    }
    

}