package com.foodparcel.factory;

import com.foodparcel.entity.Volunteer;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class VolunteerFactoryTest {

    @Test
    public void createVolunteer() {

        Volunteer volunteer = VolunteerFactory.createVolunteer(UUID.randomUUID().toString(),"Mncedisi","Mngadi",0745664245,911451256);

        assertNotNull(volunteer);

    }
}