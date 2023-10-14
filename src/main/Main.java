package main;

public class Main {
    private static final PersonService service = new PersonService();
    public static void main(String[] args) {
        service.createTable();
    }
}
