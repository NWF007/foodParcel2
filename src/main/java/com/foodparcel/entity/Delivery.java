
package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Craig Bailey
 * 216178185
 */

@Entity
public class Delivery  {

    @Id
    private String deliveryID;
    private String deliveryAddress, deliveryDate;

    protected Delivery(){

    }

    public Delivery(Builder builder){
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.deliveryID = builder.deliveryID;

    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }

    public String getDeliveryDate(){
        return deliveryDate;
    }

    public String getDeliveryID(){
        return deliveryID;
    }

    @Override
    public String toString(){
        return "Delivery{\n"+
                "deliveryAddress=' " + deliveryAddress + '\''+
                ",\n deliveryDate=' " + deliveryAddress + '\''+
                ", \n deliveryID=' " + deliveryID + "\n" + '}';
    }

    public static class Builder{
        private String deliveryAddress, deliveryDate, deliveryID;

        public Builder setDeliveryAddress (String deliveryAddress){
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setDeliveryDate (String deliveryDate){
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setDeliveryID (String deliveryID){
            this.deliveryID = deliveryID;
            return this;
        }

        public Builder copy (Delivery delivery){
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryDate = delivery.deliveryDate;
            this.deliveryID = delivery.deliveryID;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }

        public void setDelivery(String long_street, String s, String s1) {
        }
    }

}