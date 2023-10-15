package main;

public class Person {
    private Long id;
    private String firstname;
    private String lastname;
    private String nationalCode;
    private int age;

    public Person(String firstname, String lastname, String nationalCode, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.age = age;
    }

    public Person(Long id, String firstname, String lastname, String nationalCode, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.age = age;
    }

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
