//package com.foodparcel.Repository;
//
//import com.foodparcel.entity.Volunteer;
//import com.foodparcel.factory.VolunteerFactory;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
////Mncedisi Mngadi
////214210286
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class VolunteerRepositoryImplTest {
//
//    @Autowired
//    private VolunteerRepository volunteerRepository ;
//    private static Volunteer volunteer = VolunteerFactory.builderVolunteer("Mncedisi","Mngadi",+27021515,9651511);
//
//
//    @Test
//    public void a_create() {
//
//        Volunteer created = volunteerRepository.create(volunteer);
//        assertEquals(volunteer.getVolunteerNum(), created.getVolunteerNum());
//        System.out.println("Created: "+created);
//
//    }
//
//    @Test
//    public void b_read() {
//
//        Volunteer read = volunteerRepository.read(volunteer.getVolunteerNum());
//        assertNotNull(read);
//        System.out.println("Read: "+read);
//
//    }
//
//    @Test
//    public void c_update() {
//
//        Volunteer updated = new Volunteer.Builder().copy(volunteer).setFirstName("John").build();
//        updated = volunteerRepository.update(updated);
//        assertNotEquals(updated, volunteer);
//        System.out.println("Updated: "+updated);
//
//    }
//
//    @Test
//    public void d_getAll() {
//
//        assertNotNull(volunteer);
//        System.out.println("Display: "+volunteerRepository.findAll());
//
//    }
//    @Test
//    public void f_delete1() {
//
//        boolean deleted  = volunteerRepository.delete1(volunteer.getVolunteerNum());
//        Assert.assertTrue(deleted);
//        System.out.println("Deleted: "+volunteer);
//
//    }
//
//    @Test
//    public void e_isAvailable(){
//
//        Volunteer availability = new Volunteer.Builder().copy(volunteer).setAvailability(true).build();
//        availability = volunteerRepository.isAvailable(availability);
//        assertNotSame(volunteer, availability);
//        System.out.println("before availability update: "+volunteer);
//        System.out.println("Updated: "+availability);
//
//    }
//}