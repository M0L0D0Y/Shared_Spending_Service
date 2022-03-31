package service;

import module.Expence;
import module.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private List<Person> personList = new ArrayList<>();
    private List<Expence> expenceList = new ArrayList<>();
    private final GenerateId generateId = new GenerateId();

    public void addPersons(String name) {
        Person person = new Person(generateId.generate(), name);
        personList.add(person);
    }

    public void addExpence(String name, Person from, BigDecimal amount) {
        List<Person> listDebtor = personList;
        listDebtor.remove(from);
        BigDecimal number = BigDecimal.valueOf(personList.size());
        BigDecimal duty = amount.divide(number);
        for (Person person : listDebtor) {
            Expence expence = new Expence(generateId.generate(), name, from, person, duty);
            expenceList.add(expence);
        }
    }

}
