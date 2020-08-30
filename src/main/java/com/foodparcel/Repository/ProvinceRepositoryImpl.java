package com.foodparcel.Repository;

import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import java.util.HashSet;
import java.util.Set;
//Mncedisi Mngadi
//214210286

public class ProvinceRepositoryImpl implements ProvinceRepository {

    private static ProvinceRepository repository = null;
    private Set<Province> provincesDB;

    private ProvinceRepositoryImpl(){

            this.provincesDB = new HashSet<>();
    }

    public static ProvinceRepository getRepository(){

        if(repository == null) repository = new ProvinceRepositoryImpl();
        return  repository;

    }

    @Override
    public Province create(Province province) {
       this.provincesDB.add(province);
       return province;
    }

    @Override
    public Province read(String s) {

       /*Province province = this.provincesDB.stream().filter(r -> r.getProvinceId().trim().equalsIgnoreCase(s))
               .findAny().orElse(null);

       return province;*/

       for (Province province : this.provincesDB){

           if (province.getProvinceId().equalsIgnoreCase(s)) return province;

       }

        return null;
    }

    @Override
    public Province update(Province province) {
        Province oldProvince = read(province.getProvinceId());

        if(oldProvince !=null){

            this.provincesDB.remove(oldProvince);
            this.provincesDB.add(province);

        }
        return province;
    }

    @Override
    public Set<Province> getAll() {
        return this.provincesDB;
    }

    @Override
    public boolean delete1(String id) {
        Province province = read(id);

        if (province !=null){

            this.provincesDB.remove(province);
            return true;
        }

        return false;
    }

    @Override
    public void delete(String s) {
    }
}


