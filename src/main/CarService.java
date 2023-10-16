package main;

public class CarService {
    private final CarRepository repository = new CarRepository();

    /*create table if not exists*/
    public int create() {
        if (!repository.checkTableExists()) {
            return repository.create();
        }
        return -1;
    }

    public int insert(Car car) {
        /*place businesses here like age must be 18 years old*/
        return repository.insert(car);
    }
}
