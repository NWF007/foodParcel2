package com.foodparcel.entity;

import java.io.Serializable;

public class Province implements Serializable {

    private String provinceId ="";
    private String provinceDesc = "";

    private Province(){}

    public Province(Builder provinceBuilder) {
        this.provinceId = provinceBuilder.provinceId;
        this.provinceDesc = provinceBuilder.provinceDesc;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public String getProvinceDesc() {
        return provinceDesc;
    }

    @Override
    public String toString() {
        return "ProvinceBuilder{" +
                "provinceId='" + provinceId + '\'' +
                ", provinceDesc='" + provinceDesc + '\'' +
                '}';
    }

    public static class Builder{

        private String provinceId ="";
        private String provinceDesc ="";


        public Builder setProvinceId(String provinceId) {
            this.provinceId = provinceId;
            return this;
        }

        public Builder setProvinceDesc(String provinceDesc) {
            this.provinceDesc = provinceDesc;
            return this;
        }

        public Builder copy(Province province){
            this.provinceId = province.provinceId;
            this.provinceDesc = province.provinceDesc;
            return this;
        }

        public Province build(){
            return new Province(this);
        }

    }

}