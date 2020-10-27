//package com.foodparcel.Service.impl;
//
//import com.foodparcel.Repository.VolunteerProvinceRepository;
//import com.foodparcel.Repository.VolunteerRepository;
//import com.foodparcel.Service.VolunteerProvinceService;
//import com.foodparcel.Service.VolunteerService;
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
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class VolunteerProvinceServiceImplTest {
//
//
//    private static VolunteerProvinceService service = VolunteerProvinceServiceImpl.getService();
//    private static VolunteerProvince volunteerProvince = VolunteerProvinceFactory.buildVolunteerProvince("14515","241515");
//
//
//
//    @Test
//    public void a_create() {
//
//        VolunteerProvince created = service.create(volunteerProvince);
//        assertEquals(volunteerProvince.getVolunteerNum(), created.getVolunteerNum());
//        System.out.println("Created: "+created);
//
//    }
//
//    @Test
//    public void b_read() {
//
//        VolunteerProvince read = service.read(volunteerProvince.getVolunteerNum());
//        assertNotNull(read);
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    public void c_update() {
//
//        VolunteerProvince updated = new VolunteerProvince.Builder().copy(volunteerProvince).setProvinceNum("4512").build();
//        updated = service.update(updated);
//        assertNotEquals(updated, volunteerProvince);
//        System.out.println("Updated: "+updated);
//
//    }
//
//    @Test
//    public void d_getAll() {
//
//        Set<VolunteerProvince> volunteerProvinces = service.getAll();
//        assertEquals(1,volunteerProvinces.size());
//        System.out.println("These are all Volunteers: "+volunteerProvinces);
//
//    }
//
//    @Test
//    public void e_delete1() {
//        boolean deleted  = service.delete1(volunteerProvince.getVolunteerNum());
//        Assert.assertTrue(deleted);
//        System.out.println("Deleted: "+volunteerProvince);
//    }
//
//
//}