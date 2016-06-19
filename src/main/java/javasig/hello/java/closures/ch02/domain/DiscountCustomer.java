package javasig.hello.java.closures.ch02.domain;

public class DiscountCustomer {
    private String givenName;
    private String surName;
    private int age;
    private String city;
    private Gender gender;
    private int loyalty;

    public DiscountCustomer() {

    }

    public DiscountCustomer(Customer customer) {
        super();
        this.givenName = customer.getGivenName();
        this.surName = customer.getSurName();
        this.age = customer.getAge();
        this.city = customer.getCity();
        this.gender = customer.getGender();
        this.loyalty = customer.getLoyalty();
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

    @Override
    public String toString() {
        return "DiscountCustomer{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", loyalty=" + loyalty +
                '}';
    }
}
