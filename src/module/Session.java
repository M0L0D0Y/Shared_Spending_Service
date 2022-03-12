package module;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private final List<Person> personList = new ArrayList<>();//список участников сессии
    List<String> listDebtors = new ArrayList<>();//список должников
    List<String> listBorrowers = new ArrayList<>();//список заемщиков
    List<Double> listExpences = new ArrayList<>();//список трат

}
