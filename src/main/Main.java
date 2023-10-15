package main;

public class Main {
    private static final PersonService service = new PersonService();
    public static void main(String[] args) {
        System.out.println(service.createTable());
        System.out.println(service.insert(new Person("ali", "mirzad", "449", 19)));
        System.out.println(service.insert(new Person("sana", "alimardani", "448", 23)));
        System.out.println(service.insert(new Person("saba", "alimardani", "447", 44)));
        System.out.println(service.insert(new Person("sahar", "kazemi", "446", 12)));
    }
}
