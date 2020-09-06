package com.foodparcel.Service.impl;

import com.foodparcel.Service.InventoryService;
import com.foodparcel.entity.Inventory;
import com.foodparcel.factory.InventoryFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryServiceImplTest {
    
    private static InventoryService service = InventoryServiceImpl.getService();
    private static Inventory inventory = InventoryFactory.createInventory(10);
    
    @Test
    public void d_getAll(){
        Assert.assertNotNull(service);
        System.out.println("Get All: " + service.getAll());
    }
    
    @Test
    public void a_create(){
        Inventory created = service.create(inventory);
        Assert.assertEquals(inventory.getParcelsInStock(),created.getParcelsInStock());
        System.out.println("Created: " + created);
    }
    
    @Test
    public void b_read(){
        Inventory read = service.create(inventory);
        System.out.println("Read:" +read);
    }
    
    @Test
    public void c_update(){
        Inventory updated = new Inventory.InventoryBuilder().copy(inventory).setParcelsInStock(10).build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    
    @Test
    public void f_delete(){
        service.delete(inventory.getParcelsInStock());
        Assert.assertNotNull(service);
        System.out.println("Deleted: " +service.getAll());
    }
    
}

