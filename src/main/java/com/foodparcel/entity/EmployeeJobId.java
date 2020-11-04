package com.foodparcel.entity;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import java.io.Serializable;
import java.util.Objects;

public class EmployeeJobId implements Serializable {

    private String employeeNumber, jobNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeJobId that = (EmployeeJobId) o;
        return employeeNumber.equals(that.employeeNumber) &&
                jobNumber.equals(that.jobNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, jobNumber);
    }
}
