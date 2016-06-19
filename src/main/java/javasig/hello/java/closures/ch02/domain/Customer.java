package javasig.hello.java.closures.ch02.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String givenName;
    private String surName;
    private int age;
    private String city;
    private Gender gender;
    private int loyalty;

    public Customer() {

    }

    private Customer(Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        city = builder.city;
        gender = builder.gender;
        loyalty = builder.loyalty;
    }


    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public static void main(String[] args) {

    }

    public static final class Builder {
        private String givenName;
        private String surName;
        private int age;
        private String city;
        private Gender gender;
        private int loyalty;

        public Builder() {
        }

        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder loyalty(int loyalty) {
            this.loyalty = loyalty;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public boolean livesIn(String city) {
        return city.equals(this.city);
    }

    public String toString() {
        return "givenName=" + givenName + ", surName=" + surName + ", age=" + age +
                ", city=" + city + ", gender=" + gender + ", loyalty=" + loyalty ;
    }

    public DiscountCustomer createDiscountCustomer() {
        return new DiscountCustomer(this);
    }

    public static List<Customer> seedCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer.Builder().givenName("Alex").surName("Boyd")
                .gender(Gender.MALE).age(21).city("Sacramento").loyalty(2).build());
        customers.add(new Customer.Builder().givenName("Barbara").surName("Layne")
                .gender(Gender.FEMALE).age(23).city("Jersey City").loyalty(1).build());
        customers.add(new Customer.Builder().givenName("Carl").surName("Junior")
                .gender(Gender.MALE).age(24).city("New York").loyalty(3).build());
        customers.add(new Customer.Builder().givenName("Diane").surName("Perry")
                .gender(Gender.FEMALE).age(32).city("New York").loyalty(4).build());
        customers.add(new Customer.Builder().givenName("Eli").surName("Fathers")
                .gender(Gender.MALE).age(67).city("Chicago").build());
        customers.add(new Customer.Builder().givenName("Fan").surName("Li")
                .gender(Gender.FEMALE).age(55).city("New York").loyalty(2).build());
        customers.add(new Customer.Builder().givenName("Girish").surName("Patel")
                .gender(Gender.MALE).age(43).city("Edison").loyalty(2).build());
        return customers;
    }
}
