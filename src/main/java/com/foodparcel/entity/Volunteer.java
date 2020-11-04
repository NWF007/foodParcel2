package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Volunteer implements Serializable {

    @Id
    private String volunteerNum = "";
    private boolean availability = false;
    private String fName = "", lName ="";
    private long phoneNum, idNumber;
    private int deliveriesMade = 0;
    private int hoursWorked = 0;

    protected Volunteer(){}

    private Volunteer(Builder volunteer) {

        this.volunteerNum = volunteer.volunteerNum;
        this.fName = volunteer.fName;
        this.lName = volunteer.lName;
        this.phoneNum = volunteer.phoneNum;
        this.idNumber = volunteer.idNumber;
        this.availability = volunteer.availability;
        this.deliveriesMade = volunteer.diliveriesMade;
        this.hoursWorked = volunteer.hoursWorked;

    }

    public String getVolunteerNum() {
        return volunteerNum;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public int getDeliveriesMade() {
        return deliveriesMade;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerNum=" + volunteerNum +
                ", availability=" + availability +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNum=" + phoneNum +
                ", idNumber=" + idNumber +
                ", deliveriesMade=" + deliveriesMade +
                ", hoursWorked=" + hoursWorked +
                '}';
    }

    public static class Builder {

        private String volunteerNum = "";
        private String fName="", lName="";
        private long phoneNum =0, idNumber =0;
        private String homeLanguge = "";
        private boolean availability;
        private int diliveriesMade = 0, hoursWorked = 0;

        public  Builder setVolunteerNum(String volunteerNum){

            this.volunteerNum = volunteerNum;
            return this;
        }

        public Builder setFirstName(String fName){

            this.fName = fName;
            return this;
        }

        public Builder setLastName(String lName){

            this.lName = lName;
            return this;
        }

        public Builder setPhoneNumber(long phoneNum){

            this.phoneNum = phoneNum;
            return this;
        }

        public Builder setIdNumber(long idNumber){

            this.idNumber = idNumber;
            return this;
        }

        public Builder setHomeLanguge(String homeLanguge) {
            this.homeLanguge = homeLanguge;
            return this;
        }

        public Builder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder setDiliveriesMade(int diliveriesMade) {
            this.diliveriesMade = diliveriesMade;
            return this;
        }

        public Builder setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
            return this;
        }

        public Builder copy(Volunteer volunteer) {

            this.volunteerNum = volunteer.volunteerNum;
            this.availability = volunteer.availability;
            this.diliveriesMade = volunteer.deliveriesMade;
            this.hoursWorked = volunteer.hoursWorked;
            this.fName = volunteer.fName;
            this.lName = volunteer.lName;
            this.idNumber = volunteer.idNumber;
            this.phoneNum = volunteer.phoneNum;

            return this;
        }

        public Volunteer build() {

            return new Volunteer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return volunteerNum.equals(volunteer.volunteerNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volunteerNum);
    }
}