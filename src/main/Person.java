package main;

public class Person {
    /*properties*/
    private Long id;
    private String firstname;
    private String lastname;
    private String nationalCode;
    private int age;
    private Car car;

    /*costume constructor*/
    public Person() {
    }

    public Person(Long id, String firstname, String lastname, String nationalCode, int age, Car car) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.age = age;
        this.car = car;
    }

    public Person(String firstname, String lastname, String nationalCode, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.age = age;
    }

    public Person(String firstname, String lastname, String nationalCode, int age, Car car) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.age = age;
        this.car = car;
    }

    /*getter & setter*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /*implement toString method*/
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", age=" + age +
                '}';
    }
}
