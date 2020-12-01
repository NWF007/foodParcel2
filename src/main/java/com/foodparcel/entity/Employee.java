package com.foodparcel.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String employeeNumber;
    private String identityNumber, firstName, lastName,  employmentDate;

    protected Employee() {}

    public Employee(EmployeeBuilder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.employmentDate = builder.employmentDate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "employeeNumber='" + employeeNumber + '\'' +
                ",\n identityNumber='" + identityNumber + '\'' +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n employmentDate='" + employmentDate + '\'' +
                '}';
    }

    public static class EmployeeBuilder {
        private String employeeNumber, identityNumber, firstName, lastName, employmentDate;

        public EmployeeBuilder(){

        }

        public EmployeeBuilder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public EmployeeBuilder setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public EmployeeBuilder setEmploymentDate(String employmentDate) {
            this.employmentDate = employmentDate;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.identityNumber = employee.identityNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.employmentDate = employee.employmentDate;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        };

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeBuilder that = (EmployeeBuilder) o;
            return employeeNumber.equals(that.employeeNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber);
        }
    }
}
