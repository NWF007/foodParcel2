package com.foodparcel.Repository.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonationRepository;
import com.foodparcel.entity.Donation;
import com.foodparcel.entity.Donor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
public class DonationRepositoryImpl implements DonationRepository {

    private static DonationRepository donationRepository = null;
    private Set<Donation> donationDB;

    private DonationRepositoryImpl() {
        this.donationDB = new HashSet<>();
    }

    //singleton
    public static DonationRepository getDonationRepository(){
        if(donationRepository == null) donationRepository = new DonationRepositoryImpl();
        return donationRepository;
    }

    @Override
    public Donation create(Donation donation) {
        this.donationDB.add(donation);
        return donation;
    }

    @Override
    public Donation read(String donationId) {
        Donation donation = this.donationDB.stream().filter(d -> d.getDonationId().trim().equalsIgnoreCase(donationId)).findAny()
                .orElse(null);
        return donation;
    }

    @Override
    public Donation update(Donation donation) {
        Donation oldDonation = read(donation.getDonationId());
        if(oldDonation != null){
            this.donationDB.remove(oldDonation);
            this.donationDB.add(donation);
        }
        return donation;
    }

    @Override
    public void delete(String donationId) {
        Donation donation = read(donationId);
        if(donation != null){
            this.donationDB.remove(donation);
        }
    }

    @Override
    public Set<Donation> getAll() {
        return this.donationDB;
    }
}