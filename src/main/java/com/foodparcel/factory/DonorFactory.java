<<<<<<< HEAD
package com.foodparcel.factory;

import com.foodparcel.entity.Donor;
import com.foodparcel.util.IDGenerator;

public class DonorFactory {
    public static Donor createDonor(String firstName, String surname, String email, String phoneNumber){
        String id = IDGenerator.generateId();
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
=======
package com.foodparcel.factory;

import com.foodparcel.entity.Donor;
import com.foodparcel.util.IDGenerator;

public class DonorFactory {
    public static Donor createDonor(String firstName, String surname, String email, String phoneNumber){
        String id = IDGenerator.generateId();
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
>>>>>>> fa981789147286f0246885eb07d61397839685d1
