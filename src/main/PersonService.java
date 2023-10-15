package main;

public class PersonService {
    /*service classes used for implement businesses*/
    private final PersonRepository repository = new PersonRepository();
    public int createTable() {
        /*checked if table not exists then create the table.*/
        if (!repository.checkTableExists()) {
            return repository.createTable();
        }
        return -1;
    }

    public int insert(Person person) {
        /*place businesses here like age must be 18 years old*/
        return repository.insert(person);
    }
}
