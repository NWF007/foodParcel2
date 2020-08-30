package com.foodparcel.factory;

import com.foodparcel.entity.Province;
import com.foodparcel.util.IDGenerator;

public class ProvinceFactory {

    public static Province createProvince(String provinceId, String provinceDesc){

        Province province = new Province.Builder()
                .setProvinceId(provinceId)
                .setProvinceDesc(provinceDesc)
                .build();

        return province;
    }

    public static Province builderProvince(String province){

        String provinceId = IDGenerator.generateId();
        return new Province.Builder().setProvinceId(provinceId).setProvinceDesc(province).build();
    }


}
