package com.foodparcel.factory;

import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;
import com.foodparcel.util.IDGenerator;

public class VolunteerProvinceFactory {

    public static VolunteerProvince buildVolunteerProvince(String volunteerNum, String provinceNum){

        String volunteerProvinceId = IDGenerator.generateId();
        VolunteerProvince volunteerProvince = new VolunteerProvince.Builder()
                .setVolunteerNum(volunteerNum)
                .setProvinceNum(provinceNum)
                .build();

        return volunteerProvince;

    }

}
