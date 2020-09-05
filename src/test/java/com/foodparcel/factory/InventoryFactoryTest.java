package com.foodparcel.factory;

import com.foodparcel.entity.Inventory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryFactoryTest {

    @Test
    public void getParcelsInStock() {
        Inventory inventory = InventoryFactory.createInventory(5);
        System.out.println(inventory);
        Assert.assertEquals(5, inventory.getParcelsInStock());
    }
}