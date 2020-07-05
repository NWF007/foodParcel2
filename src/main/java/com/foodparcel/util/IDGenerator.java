package com.foodparcel.util;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import java.util.UUID;

public class IDGenerator {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

}
