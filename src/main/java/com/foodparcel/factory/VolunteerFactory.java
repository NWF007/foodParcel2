package com.foodparcel.factory;

import com.foodparcel.entity.Province;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.util.IDGenerator;

public class VolunteerFactory {

    public static Volunteer createVolunteer(String volunteerNum,String fName, String lName, long phonNum,long idNum){


        Volunteer volunteer = new Volunteer.Builder()
                .setVolunteerNum(volunteerNum)
                .setFirstName(fName)
                .setLastName(lName)
                .setPhoneNumber(phonNum)
                .setIdNumber(idNum)
                .build();

        return volunteer;
    }

    public static Volunteer builderVolunteer(String fname,String lName, long phoneNum, long idNum){

        String volunteerId = IDGenerator.generateId();
        return new Volunteer.Builder()
                .setVolunteerNum(volunteerId)
                .setFirstName(fname)
                .setLastName(lName)
                .setPhoneNumber(phoneNum)
                .setIdNumber(idNum)
                .build();
    }


}
