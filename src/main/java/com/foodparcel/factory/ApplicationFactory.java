package com.foodparcel.factory;
import com.foodparcel.entity.Application;

public class ApplicationFactory {
    public static Application createApplication(long id, String firstName, String lastName,
                                                long contactNumber, String homeAddress, int numberOfDependants, double income) {
        if (id != 0) {
            Application a = new Application.Builder().
                    setid(id)
                    .setfirstName(firstName).setlastName(lastName)
                    .setcontactNumber(contactNumber).sethomeAddress(homeAddress)
                    .setnumberOfDependants(numberOfDependants)
                    .setIncome(income)
                    .build();
            return a;
        }else
            return null;
    }
}
