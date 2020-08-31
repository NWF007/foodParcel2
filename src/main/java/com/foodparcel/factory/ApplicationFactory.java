package com.foodparcel.factory;
import com.foodparcel.entity.Application;

public class ApplicationFactory {
    public static Application createApplication(String id, String firstName, String lastName,
                                                String contactNumber, String homeAddress, int numberOfDependants, double income) {
        if (!id.equals("0")) {
            return new Application.Builder().
                    setid(id)
                    .setfirstName(firstName).setlastName(lastName)
                    .sethomeAddress(homeAddress).setcontactNumber(contactNumber)
                    .setnumberOfDependants(numberOfDependants)
                    .setIncome(income)
                    .build();
        }else
            return null;
    }
}
