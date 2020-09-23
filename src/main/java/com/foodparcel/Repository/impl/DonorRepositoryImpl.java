package com.foodparcel.Repository.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.entity.Donor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

public class DonorRepositoryImpl implements DonorRepository {

    private static DonorRepository donorRepository = null;
    private Set<Donor> donorDB;

    private DonorRepositoryImpl() {
        this.donorDB = new HashSet<>();
    }

    //singleton
    public static DonorRepository getDonorRepository(){
        if(donorRepository == null) donorRepository = new DonorRepositoryImpl();
        return donorRepository;
    }

    @Override
    public Donor create(Donor donor) {
        this.donorDB.add(donor);
        return donor;
    }

    @Override
    public Donor read(String id) {
        Donor donor = this.donorDB.stream().filter(d -> d.getId().trim().equalsIgnoreCase(id)).findAny()
                .orElse(null);
        return donor;
    }

    @Override
    public Donor update(Donor donor) {
        Donor oldDonor = read(donor.getId());
        if(oldDonor != null){
            this.donorDB.remove(oldDonor);
            this.donorDB.add(donor);
        }
        return oldDonor;
    }

    @Override
    public void delete(String id) {
        Donor donor = read(id);
        if(donor != null){
            this.donorDB.remove(donor);
        }
    }

    @Override
    public Set<Donor> getAll() {
        return this.donorDB;
    }
}
