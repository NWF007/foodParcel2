//package com.foodparcel.Repository.impl;
//
//import com.foodparcel.Repository.VolunteerProvinceRepository;
//import com.foodparcel.entity.Volunteer;
//import com.foodparcel.entity.VolunteerProvince;
//import com.foodparcel.factory.VolunteerFactory;
//import com.foodparcel.factory.VolunteerProvinceFactory;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//Mncedisi Mngadi
//214210286
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class VolunteerProvinceRepositoryImplTest {
//
//    private static VolunteerProvinceRepository repository = VolunteerProvinceRepositoryImpl.getRepository();
//    private static VolunteerProvince entity = VolunteerProvinceFactory.buildVolunteerProvince("22", "23");
//
//
//    @Test
//    public void a_create() {
//
//        VolunteerProvince saved = repository.create(entity);
//        assertNotNull(saved);
//        assertEquals(entity.getVolunteerNum(), saved.getVolunteerNum());
//
//    }
//
//    @Test
//    public void b_read() {
//
//        VolunteerProvince read = repository.read(entity.getVolunteerNum());
//        assertNotNull(read);
//        assertEquals(entity.getVolunteerNum(), read.getVolunteerNum());
//
//    }
//
//    @Test
//    public void c_update() {
//
//        VolunteerProvince updated = new VolunteerProvince.Builder().copy(entity).setVolunteerNum("500").build();
//        updated = repository.update(updated);
//        assertNotEquals(updated, entity);
//        System.out.println("Updated: "+updated);
//
//    }
//
//    @Test
//    public void d_getAll() {
//
//        Set<VolunteerProvince> volunteerProvinces = repository.getAll();
//        assertNotNull(volunteerProvinces);
//        System.out.println(volunteerProvinces);
//
//    }
//
//    @Test
//    public void e_delete1() {
//
//        boolean deleted  = repository.delete1(entity.getVolunteerNum());
//        Assert.assertTrue(deleted);
//        System.out.println("Deleted: "+entity);
//
//    }
//}