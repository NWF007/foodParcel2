package com.foodparcel.entity;

public class Employee {
    private String employeeNumber, identityNumber, firstName, lastName,  employmentDate;
    private Job jobTitle, department;

    public Employee() {}

    public Employee(EmployeeBuilder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.jobTitle = builder.jobTitle;
        this.department = builder.department;
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
        return jobTitle;
    }

    public Job getDepartment() {
        return department;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", jobTitle=" + jobTitle +
                ", department=" + department +
                '}';
    }

    public static class EmployeeBuilder {
        private String employeeNumber, identityNumber, firstName, lastName, employmentDate;
        private Job jobTitle, department;

        public EmployeeBuilder(String employeeNumber, String identityNumber, String firstName, String lastName, String employmentDate, Job jobTitle, Job department) {
            this.employeeNumber = employeeNumber;
            this.identityNumber = identityNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.employmentDate = employmentDate;
            this.jobTitle = jobTitle;
            this.department = department;
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

        public EmployeeBuilder setDepartment(Job department) {
            this.department = department;
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
            this.jobTitle = employee.jobTitle;
            this.department = employee.department;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        };
    }
}
