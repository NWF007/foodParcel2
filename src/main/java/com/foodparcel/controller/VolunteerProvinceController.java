package com.foodparcel.controller;

import com.foodparcel.Service.impl.ProvinceServiceImpl;
import com.foodparcel.Service.impl.VolunteerProvinceServiceImpl;
import com.foodparcel.Service.impl.VolunteerServiceImpl;
import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.entity.VolunteerProvince;
import com.foodparcel.factory.VolunteerProvinceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/foodparcel/volunteerProvince")
public class VolunteerProvinceController {

    @Autowired
    private VolunteerProvinceServiceImpl service;

    @Autowired
    private VolunteerServiceImpl volunteerService;

    @Autowired
    private ProvinceServiceImpl provinceService;

    @PostMapping("/create")
    public VolunteerProvince create(@RequestBody VolunteerProvince volunteerProvince){

        boolean volunteerExisting = false;
        boolean provinceExisting = false;

        Volunteer volunteer = volunteerService.read(volunteerProvince.getVolunteerNum());

        if(volunteer !=null){

            volunteerExisting = true;


        }

        Province province = provinceService.read(volunteerProvince.getProvinceNum());
        if (province !=null){

            provinceExisting = true;

        }

        if(volunteerExisting && provinceExisting){

            return service.create(volunteerProvince);

        }else {

            return VolunteerProvinceFactory.buildVolunteerProvince("", "");
        }




    }

    @GetMapping("/all")
    public  Set<VolunteerProvince> all(){

        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public VolunteerProvince read(@PathVariable String id){

        return service.read(id);
    }

    @PostMapping("/update")
    public VolunteerProvince update(@RequestBody VolunteerProvince volunteerProvince){
        return service.update(volunteerProvince);
    }



    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){

        return service.delete1(id);
    }


}
