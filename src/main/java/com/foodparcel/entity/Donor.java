package com.foodparcel.entity;

public class Donor {
    public String firstName, surname, email, id, phoneNumber;

    public Donor(Builder builder) {
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.email = builder.email;
        this.id = builder.id;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", ID=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public static class Builder {
        public String firstName, surname, email, id, phoneNumber;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder copy (Donor donor) {
            this.firstName = donor.firstName;
            this.surname = donor.surname;
            this.email = donor.email;
            this.id = donor.id;
            this.phoneNumber = donor.phoneNumber;
            return this;
        }

        public Donor build() {
            return new Donor (this);
        }
    }

}


