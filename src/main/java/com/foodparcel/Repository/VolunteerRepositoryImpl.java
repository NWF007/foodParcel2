//package com.foodparcel.Repository;
//
//import com.foodparcel.entity.Province;
//import com.foodparcel.entity.Volunteer;
//import java.util.HashSet;
//import java.util.Set;
////Mncedisi Mngadi
////214210286
//
//public class VolunteerRepositoryImpl implements VolunteerRepository {
//
//
//    private static VolunteerRepository repository = null;
//    private Set<Volunteer> volunteersDB;
//
//    private VolunteerRepositoryImpl(){
//
//        this.volunteersDB = new HashSet<>();
//    }
//
//    public static VolunteerRepository getRepository(){
//
//        if(repository == null) repository = new VolunteerRepositoryImpl();
//        return  repository;
//
//    }
//
//    @Override
//    public Set<Volunteer> getAll() {
//
//        return this.volunteersDB;
//
//    }
//
//    @Override
//    public Volunteer create(Volunteer volunteer) {
//        this.volunteersDB.add(volunteer);
//        return volunteer;
//    }
//
//    @Override
//    public Volunteer read(String volunteerId) {
//
//        for (Volunteer volunteer : this.volunteersDB){
//
//            if (volunteer.getVolunteerNum().equals(volunteerId)) return volunteer;
//
//        }
//
//        return null;
//    }
//
//    @Override
//    public Volunteer update(Volunteer volunteer) {
//        Volunteer oldVolunteer = read(volunteer.getVolunteerNum());
//
//        if(oldVolunteer !=null){
//
//            this.volunteersDB.remove(oldVolunteer);
//            this.volunteersDB.add(volunteer);
//
//        }
//        return volunteer;
//    }
//
//    @Override
//    public boolean delete1(String s) {
//        Volunteer volunteer = read(s);
//
//        if (volunteer !=null){
//
//            this.volunteersDB.remove(volunteer);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public Volunteer isAvailable(Volunteer volunteer) {
//
//        Volunteer oldVolunteer = read(volunteer.getVolunteerNum());
//
//        if(oldVolunteer !=null){
//
//            this.volunteersDB.remove(oldVolunteer);
//            this.volunteersDB.add(volunteer);
//
//        }
//        return volunteer;
//    }
//
//    @Override
//    public void delete(String s) {
//
//    }
//
//}
