package com.foodparcel.factory;

import com.foodparcel.entity.Volunteer;
import org.junit.Test;

import static org.junit.Assert.*;

public class VolunteerFactoryTest {

    @Test
    public void createVolunteer() {

        Volunteer volunteer = VolunteerFactory.createVolunteer("Mncedisi","Mngadi",0745664245,"Isizulu",911451256,"Kwazulu Natal");

        assertNotNull(volunteer);

    }
}