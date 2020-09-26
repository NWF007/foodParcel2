package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.Repository.impl.DonorRepositoryImpl;
import com.foodparcel.Service.DonorService;
import com.foodparcel.entity.Donor;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DonorServiceImpl implements DonorService {

    private static DonorService donorService = null;
    private DonorRepository donorRepository;

    private DonorServiceImpl(){
        this.donorRepository = DonorRepositoryImpl.getDonorRepository();
    }

    public static DonorService getDonorService(){
        if (donorService == null) donorService = new DonorServiceImpl();
        return donorService;
    }


    @Override
    public Set<Donor> getAll() {
        return this.donorRepository.getAll();
    }

    @Override
    public Donor create(Donor donor) {
        return this.donorRepository.create(donor);
    }

    @Override
    public Donor read(String s) {
        return this.donorRepository.read(s);
    }

    @Override
    public Donor update(Donor donor) {
        return this.donorRepository.update(donor);
    }

    @Override
    public void delete(String s) {
        this.donorRepository.delete(s);
    }
}
