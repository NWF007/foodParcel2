package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonationRepository;
import com.foodparcel.Service.DonationService;
import com.foodparcel.entity.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public Set<Donation> getAll() {
        return this.donationRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Donation create(Donation donation) {
        return this.donationRepository.save(donation);
    }

    @Override
    public Donation read(String s) {
        return this.donationRepository.findById(s).orElseGet(null);
    }

    @Override
    public Donation update(Donation donation) {
        return create(donation);
    }

    @Override
    public void delete(String s) {
        this.donationRepository.deleteById(s);
        //if (this.donationRepository.existsById(s));
            //return false;
       // return true;
    }
}
