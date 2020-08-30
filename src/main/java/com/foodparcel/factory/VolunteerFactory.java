package com.foodparcel.factory;

import com.foodparcel.entity.Volunteer;

public class VolunteerFactory {

    public static Volunteer createVolunteer(String fName, String lName, long phonNum, String homeLanguage,long idNum, String province){

        int voluNum =110;
        int volunteerNum = voluNum+1;

        Volunteer volunteer = new Volunteer.Builder()
                .setVolunteerNum(volunteerNum)
                .setFirstName(fName)
                .setLastName(lName)
                .setPhoneNumber(phonNum)
                .setIdNumber(idNum)
                .setHomeLanguge(homeLanguage)
                .setProvince(province)
                .build();

        return volunteer;
    }



}
