package main;

public class Car {
    /*properties*/
    private Long id;
    private String name;
    private int model;

    /*constructor*/
    public Car() {
    }

    public Car(Long id, String name, int model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }

    public Car(String name, int model) {
        this.name = name;
        this.model = model;
    }

    public Car(Long id) {
        this.id = id;
    }

    /*getter setter*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    /*toString implement*/
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model=" + model +
                '}';
    }
}
