package main;

public class PersonService {
    /*service classes used for implement businesses*/
    private final PersonRepository repository = PersonRepository.getInstance();
    public int createTable() {
        /*checked if table not exists then create the table.*/
        if (!repository.checkTableExists()) {
            return repository.createTable();
        }
        return -1;
    }

    public int insertWithoutCar(Person person) {
        /*place businesses here like age must be 18 years old*/
        return repository.insertWithoutCar(person);
    }

    public int insertWithCar(Person person) {
        return repository.insertWithCar(person);
    }

    public int buyCar(Person person) {
        return repository.buyCar(person);
    }
}
