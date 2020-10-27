package com.foodparcel.entity;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(EmployeeJobId.class)
public class EmployeeJob {

    @Id
    private String employeeNumber, jobNumber;

    protected EmployeeJob() {
    }

    public EmployeeJob(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.jobNumber = builder.jobNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    @Override
    public String toString() {
        return "EmployeeJob{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String jobNumber, employeeNumber;

        public Builder() {
        }

        public Builder setJobNumber(String jobNumber) {
            this.jobNumber = jobNumber;
            return this;
        }

        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return jobNumber.equals(builder.jobNumber) &&
                    employeeNumber.equals(builder.employeeNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(jobNumber, employeeNumber);
        }

        public Builder copy(EmployeeJob employeeJob){
            this.employeeNumber = employeeJob.employeeNumber;
            this.jobNumber = employeeJob.jobNumber;
            return this;
        }

        public EmployeeJob build() {
            return new EmployeeJob(this);
        }
    }
}
