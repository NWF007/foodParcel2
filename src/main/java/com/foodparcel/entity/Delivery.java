<<<<<<< HEAD
package com.foodparcel.entity;

public class Delivery {

    private String deliveryAddress, deliveryDate, deliveryID;

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
            this.deliveryDate = deliveryAddress;
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

=======
package com.foodparcel.entity;

public class Delivery {

    private String deliveryAddress, deliveryDate, deliveryID;
    private Boolean delivered;


    public Delivery(Builder builder) {
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryDate = builder.deliveryDate;
        this.delivered = builder.delivered;
        this.deliveryID = builder.deliveryID;


    }

    public String getDeliveryID(){ return deliveryID;}

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

    public void setDeliveryID(String deliveryID) {
    }

    public static class Builder {
        private String deliveryAddress, deliveryDate, deliveryID;
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

        public void setDeliveryID(String deliveryID) {
            this.deliveryID = deliveryID;
        }

        public Builder copy(Delivery delivery) {
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryDate = delivery.deliveryDate;
            this.delivered = delivery.delivered;
            this.deliveryID = delivery.deliveryID;
            return this;
        }

        public Delivery build() {

            return new Delivery(this);
        }
    }
}
>>>>>>> fa981789147286f0246885eb07d61397839685d1
