package main;

public class PersonService {
    private final PersonRepository repository = new PersonRepository();
    public void createTable() {
        /*checked if table not exists then create the table.*/
        if (!repository.checkTableExists()) {
            repository.createTable();
        }
    }
}
