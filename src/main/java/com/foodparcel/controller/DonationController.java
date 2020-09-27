package com.foodparcel.controller;

import com.foodparcel.Service.impl.DonationServiceImpl;
import com.foodparcel.entity.Donation;
import com.foodparcel.factory.DonationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/**Yusrah Soeker
 * 218150768
 */

@RestController
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private DonationServiceImpl donationService;

    @PostMapping("/create")
    public Donation create(@RequestBody Donation donation){
        Donation newDonation = DonationFactory.createDonation(donation.getDonationDate(), donation.getDonateAmount());
        return  donationService.create(newDonation);
    }

    @GetMapping(path = "/read/{id}")
    public Donation read(@PathVariable String id){
        return donationService.read(id);
    }

    @PostMapping("/update")
    public Donation update(@RequestBody Donation donation){
        return donationService.update(donation);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        donationService.delete(id);
    }

    @GetMapping("/all")
    public Set<Donation> getAll(){
        return donationService.getAll();
    }

}