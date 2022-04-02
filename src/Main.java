import module.Person;
import service.SessionManager;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addPersons("pavel");
        sessionManager.addPersons("igor");
        sessionManager.addPersons("ira");
        Person person1 = new Person(1, "pavel");
        Person person2 = new Person(2, "igor");
        Person person3 = new Person(3, "ira");
        sessionManager.addExpence("kofee",person1, person2, BigDecimal.valueOf(300));
        sessionManager.addExpence("kofee",person1, person3, BigDecimal.valueOf(300));
        sessionManager.addExpence("kofee",person2, person1, BigDecimal.valueOf(400));
        sessionManager.addExpence("kofee",person2, person3, BigDecimal.valueOf(400));
        sessionManager.addExpence("kofee",person3, person1, BigDecimal.valueOf(500));
        sessionManager.addExpence("kofee",person3, person2, BigDecimal.valueOf(500));
        sessionManager.printExpence();
    }
}

