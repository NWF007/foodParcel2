package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonationRepository;
import com.foodparcel.Repository.impl.DonationRepositoryImpl;
import com.foodparcel.Service.DonationService;
import com.foodparcel.entity.Donation;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DonationServiceImpl implements DonationService {

    private static DonationService donationService = null;
    private DonationRepository donationRepository;

    private DonationServiceImpl(){
        this.donationRepository = DonationRepositoryImpl.getDonationRepository();
    }

    public static DonationService getDonationService(){
        if (donationService == null) donationService = new DonationServiceImpl();
        return donationService;
    }


    @Override
    public Set<Donation> getAll() {
        return this.donationRepository.getAll();
    }

    @Override
    public Donation create(Donation donation) {
        return this.donationRepository.create(donation);
    }

    @Override
    public Donation read(String s) {
        return this.donationRepository.read(s);
    }

    @Override
    public Donation update(Donation donation) {
        return this.donationRepository.update(donation);
    }

    @Override
    public void delete(String s) {
        this.donationRepository.delete(s);
    }
}
