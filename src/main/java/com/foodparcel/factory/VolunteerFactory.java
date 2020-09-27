package com.foodparcel.factory;

import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.util.IDGenerator;

public class VolunteerFactory {


    public static Volunteer builderVolunteer(String fname,String lName, long phoneNum, long idNum){

        String volunteerId = IDGenerator.generateId();
        Volunteer volunteer = new Volunteer.Builder()
                .setVolunteerNum(volunteerId)
                .setFirstName(fname)
                .setLastName(lName)
                .setPhoneNumber(phoneNum)
                .setIdNumber(idNum)
                .build();

        return volunteer;

    }


}
