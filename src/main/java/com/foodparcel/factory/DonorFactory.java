package com.foodparcel.factory;

import com.foodparcel.entity.Donor;

public class DonorFactory {
    public static Donor createDonor(String firstName, String surname, String email, String id, String phoneNumber){
      Donor donor = new Donor.Builder()
              .setFirstName(firstName)
              .setSurname(surname)
              .setEmail(email)
              .setId(id)
              .setPhoneNumber(phoneNumber)
              .build();
      return donor;
    }
}
