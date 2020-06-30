package com.foodparcel.entity;

public class Delivery {

    private String deliveryAddress, deliveryDate;
    private Boolean delivered;


    public Delivery(Builder builder) {
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.delivered = builder.delivered;


    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryAddress ='" + deliveryAddress + '\'' +
                ",deliveryDate=' " + deliveryDate + '\'' +
                ",delivered=" + delivered +
                '}';
    }

    public static class Builder {
        private String deliveryAddress, deliveryDate;
        private Boolean delivered;

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setDelivered(Boolean delivered) {
            this.delivered = delivered;
            return this;
        }

        public Builder copy(Delivery delivery) {
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryDate = delivery.deliveryDate;
            this.delivered = delivery.delivered;
            return this;
        }

        public Delivery build() {

            return new Delivery(this);
        }
    }
}
