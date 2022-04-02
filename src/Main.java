import module.Person;
import service.SessionManager;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addPersons("pavel");
        sessionManager.addPersons("pavel");
        sessionManager.addPersons("denis");
        sessionManager.addPersons("olya");
        Person person1 = new Person(1, "pavel");
        Person person2 = new Person(2, "pavel");
        Person person3 = new Person(1, "denis");
        Person person4 = new Person(3, "olya");
        sessionManager.addExpence("kofee",person1, person2, BigDecimal.valueOf(10));
        sessionManager.addExpence("kofee",person1, person3, BigDecimal.valueOf(20));
        sessionManager.addExpence("kofee",person3, person1, BigDecimal.valueOf(1000));
        sessionManager.addExpence("kofee",person3, person1, BigDecimal.valueOf(22));
        sessionManager.addExpence("kofee",person1, person3, BigDecimal.valueOf(22));
        System.out.println("тест№1");
        sessionManager.printExpence();

    }
}

