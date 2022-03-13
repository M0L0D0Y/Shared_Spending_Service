package service;

import module.Expence;
import module.Person;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private final List<Person> personList = new ArrayList<>();//список участников сессии
    private final List<Expence> listExpences = new ArrayList<>();//список должников
    long id;

}
