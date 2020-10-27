package com.foodparcel.Service.impl;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.Repository.DonorRepository;
import com.foodparcel.Service.DonorService;
import com.foodparcel.entity.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Override
    public Set<Donor> getAll() {
        return this.donorRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Donor create(Donor donor) {
        return this.donorRepository.save(donor);
    }

    @Override
    public Donor read(String s) {
        return this.donorRepository.findById(s).orElseGet(null);
    }

    @Override
    public Donor update(Donor donor) {
        return create(donor);
    }

    @Override
    public void delete(String s) {
        this.donorRepository.deleteById(s);
        //if(this.donorRepository.existsById(s));
            //return false;
        //return true;
    }
}
