package com.foodparcel.entity;

public class Application {
    private String id ;
    private String firstName , lastName , homeAdrress ;
    private String contactNumber ;
    private int numberOfDependants ;
    private double income;

    private Application (Builder builder){
        this.id= builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.homeAdrress = builder.homeAdrress;
        this.contactNumber = builder.contactNumber;
        this.numberOfDependants = builder.numberOfDependants;
        this.income = builder.income;
    }
    //Getters
    public String getId() {
        return id;
    }

    public String getContactNumber() {
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
        private String id , contactNumber ;
        private int numberOfDependants ;
        private String firstName , lastName , homeAdrress ;
        private double income;


        public  Builder setid(String id) {
            this.id = id;
            return  this;
        }
        public  Builder setcontactNumber(String contactNumber) {
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
