package com.foodparcel.entity;

public class Application {
    private long id , contactNumber ;
    private int numberOfDependants ;
    private String firstName , lastName , homeAdrress ;
    private double income;

    private Application (Builder builder){
        this.id= builder.id;
        this.contactNumber = builder.contactNumber;
        this.numberOfDependants = builder.numberOfDependants;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.homeAdrress = builder.homeAdrress;
        this.income = builder.income;
    }
    //Getters
    public long getId() {
        return id;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeAdrress() {
        return homeAdrress;
    }

    public double getIncome() {
        return income;
    }

    public int getNumberOfDependants() {
        return numberOfDependants;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", contactNumber=" + contactNumber +
                ", numberOfDependants=" + numberOfDependants +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeAdrress='" + homeAdrress + '\'' +
                ", income=" + income +
                '}';
    }

    public static class Builder {
        private long id , contactNumber ;
        private int numberOfDependants ;
        private String firstName , lastName , homeAdrress ;
        private double income;


        public  Builder setid(long id) {
            this.id = id;
            return  this;
        }
        public  Builder setcontactNumber(long contactNumber) {
            this.contactNumber = contactNumber;
            return  this;
        }
        public  Builder setnumberOfDependants (int numberOfDependants){
            this.numberOfDependants = numberOfDependants;
            return  this;
        }
        public  Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return  this;
        }
        public  Builder setlastName(String lastName) {
            this.lastName = lastName;
            return  this;
        }
        public  Builder sethomeAddress(String homeAdrress) {
            this.homeAdrress = homeAdrress;
            return  this;
        }
        public  Builder setIncome (double income){
            this.income = income;
            return  this;
        }

        public Builder copy(Application application){
            this.id = application.id;
            this.contactNumber = application.contactNumber;
            this.numberOfDependants = application.numberOfDependants;
            this.firstName = application.firstName;
            this.lastName = application.lastName;
            this.homeAdrress = application.homeAdrress;
            this.income = application.income;
            return  this;
        }
        public Application build(){
            return  new Application(this);

        }
    }

}
