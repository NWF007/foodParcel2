package com.foodparcel.entity;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

public class Employee {
    private String employeeNumber, identityNumber, firstName, lastName,  employmentDate;
    private Job job;

    public Employee() {}

    public Employee(EmployeeBuilder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.job = builder.jobTitle;
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

    public Job getJobTitle() {
        return job;
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
                ",\n jobTitle=" + job  + "\n"+
                '}';
    }

    public static class EmployeeBuilder {
        private String employeeNumber, identityNumber, firstName, lastName, employmentDate;
        private Job jobTitle;

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

        public EmployeeBuilder setJobTitle(Job jobTitle) {
            this.jobTitle = jobTitle;
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
            this.jobTitle = employee.job;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        };
    }
}
