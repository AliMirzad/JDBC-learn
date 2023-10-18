package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final PersonService serviceP = new PersonService();
    private static final CarService serviceC = new CarService();
    public static void main(String[] args) {
        System.out.println(serviceC.create());

        System.out.println(serviceC.insert(new Car("z4", 2020)));
        System.out.println(serviceC.insert(new Car("m3", 2021)));
        System.out.println(serviceC.insert(new Car("m5", 2023)));
        System.out.println(serviceC.insert(new Car("740li", 2022)));

        System.out.println(serviceP.createTable());

        System.out.println(serviceP.insertWithoutCar(new Person("ali", "mirzad", "449", 19)));
        System.out.println(serviceP.insertWithoutCar(new Person("sana", "alimardani", "448", 23)));
        System.out.println(serviceP.insertWithoutCar(new Person("saba", "alimardani", "447", 44)));
        System.out.println(serviceP.insertWithoutCar(new Person("sahar", "kazemi", "446", 12)));

        System.out.println(serviceP.insertWithCar(new Person("mohamad", "mirzad", "445", 30, new Car(1L))));
        System.out.println(serviceP.insertWithCar(new Person("mahnaz", "hossini", "444", 43, new Car(2L))));

        Person person = new Person();
        Car car = new Car();
        person.setId(1L);
        person.setCar(car);
        person.getCar().setId(1L);
        System.out.println(serviceP.buyCar(person));

        person.setId(2L);
        person.getCar().setId(3L);
        System.out.println(serviceP.buyCar(person));
    }
}
