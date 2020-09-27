package com.foodparcel.controller;


import com.foodparcel.Service.impl.DonorServiceImpl;
import com.foodparcel.entity.Donor;
import com.foodparcel.factory.DonorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/**Yusrah Soeker
 * 218150768
 */

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorServiceImpl donorService;

    @PostMapping("/create")
    public Donor create(@RequestBody Donor donor){
        Donor newDonor = DonorFactory.createDonor(donor.getFirstName(), donor.getSurname(), donor.getEmail(), donor.getPhoneNumber());
        return donorService.create(newDonor);
        //return donationService.create(donation);
    }

    @GetMapping(path = "/read/{id}")
    public Donor read(@PathVariable String id){
        return donorService.read(id);
    }

    @PostMapping("/update")
    public Donor update(@RequestBody Donor donor){
        return donorService.update(donor);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        donorService.delete(id);
    }

    @GetMapping("/all")
    public Set<Donor> getAll(){
        return donorService.getAll();
    }


}
