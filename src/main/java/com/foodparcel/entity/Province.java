package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Province implements Serializable {

    @Id
    private String provinceId ="";
    private String provinceDesc = "";

    protected Province(){}

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return provinceId.equals(province.provinceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceId);
    }

}