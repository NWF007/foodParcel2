package com.foodparcel.Repository.impl;

import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.entity.Donor;
import java.util.HashSet;
import java.util.Set;

public class DonorRepositoryImpl implements DonorRepository {

    private static DonorRepository repository = null;
    private Set<Donor> donorDB;

    private DonorRepositoryImpl() {
        this.donorDB = new HashSet<>();
    }

    //singleton
    public static DonorRepository getRepository(){
        if(repository == null) repository = new DonorRepositoryImpl();
        return repository;
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
        boolean deleteDonor = delete(donor.getId());
        if (deleteDonor) {
            this.donorDB.add(donor);
            return donor;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Donor donor = read(id);
        if(donor != null){
            this.donorDB.remove(donor);
            return true;
        }
        return false;
    }

    @Override
    public Set<Donor> getAll() {
        return this.donorDB;
    }
}
