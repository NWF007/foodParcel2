package com.foodparcel.entity;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

public class Inventory {
    private int parcelsInStock;

    public Inventory(InventoryBuilder inventoryBuilder){
        this.parcelsInStock = inventoryBuilder.parcelsInStock;
    }

    public int getParcelsInStock() {
        return parcelsInStock;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "parcelsInStock=" + parcelsInStock +
                '}';
    }

    public static class InventoryBuilder {
        private int parcelsInStock;

        public InventoryBuilder() {
        }

        public InventoryBuilder setParcelsInStock(int parcelsInStock) {
            this.parcelsInStock = parcelsInStock;
            return this;
        }

        public InventoryBuilder copy(Inventory inventory){
            this.parcelsInStock = parcelsInStock;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }
    }
}
