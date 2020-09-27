package com.foodparcel.entity;

import java.io.Serializable;

public class VolunteerProvince implements Serializable {

    String volunteerNum, provinceNum;


    private VolunteerProvince(){}

    public VolunteerProvince(Builder volunteerProvinceBuilder) {
        this.provinceNum = volunteerProvinceBuilder.provinceNum;
        this.volunteerNum = volunteerProvinceBuilder.volunteerNum;
    }

    public String getVolunteerNum() {
        return volunteerNum;
    }

    public String getProvinceNum() {
        return provinceNum;
    }

    @Override
    public String toString() {
        return "VolunteerProvince{" +
                "volunteerNum='" + volunteerNum + '\'' +
                ", provinceNum='" + provinceNum + '\'' +
                '}';
    }

    public static class Builder {

        private String provinceNum = "";
        private String volunteerNum = "";


        public VolunteerProvince.Builder setProvinceNum(String provinceNum) {
            this.provinceNum = provinceNum;
            return this;
        }

        public VolunteerProvince.Builder setVolunteerNum(String volunteerNum) {
            this.volunteerNum = volunteerNum;
            return this;
        }

        public VolunteerProvince.Builder copy(VolunteerProvince volunteerProvince) {
            this.provinceNum = volunteerProvince.provinceNum;
            this.volunteerNum = volunteerProvince.volunteerNum;
            return this;
        }

        public VolunteerProvince build() {
            return new VolunteerProvince(this);
        }

    }

}
