package com.foodparcel.controller;

import com.foodparcel.Service.impl.ProvinceServiceImpl;
import com.foodparcel.entity.Province;
import com.foodparcel.factory.ProvinceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/foodparcel/province")
public class ProvinceController {

    @Autowired
    private ProvinceServiceImpl provinceService;

    @PostMapping("/create")
    public Province create(@RequestBody Province province){

        Province newProvince = ProvinceFactory.builderProvince(province.getProvinceDesc());
        return provinceService.create(newProvince);

    }

    @GetMapping("/all")
    public Set<Province> getAll(){

        return provinceService.getAll();
    }

    @GetMapping("/read/{id}")
    public Province read(@PathVariable String id){

        return provinceService.read(id);
    }

    @PostMapping("/update")
    public Province update(@RequestBody Province province){
        return provinceService.update(province);
    }



    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){

        return provinceService.delete1(id);
    }


}
