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

    public void addExpence(String name, Person from, Person to, BigDecimal amount) {
        expenceList.add(new Expence(generateId.generate(), name, from, to, amount));
    }
    public void printExpence() {
        calculateExpence();
        if (expenceList.isEmpty()) {
            System.out.println("Никто никому не должен.");
            return;
        }
        for (Expence expence : expenceList) {
            System.out.println(expence.getTo() + " должен " + expence.getFrom() + " " + expence.getAmount());
        }
    }

    private void calculateExpence() {
        for (Person person : personList) {
            List<Long> listName = new ArrayList<>();
            for (Expence item : expenceList) {
                listName.add(item.getFrom().getId());
            }
            while (listName.contains(person.getId())) {
                listName.remove(person.getId());
                for (int i = 0; i < expenceList.size(); i++) {
                    long name = expenceList.get(i).getFrom().getId();
                    for (int j = 0; j < expenceList.size(); j++) {
                        if (name == (expenceList.get(j).getTo().getId())) {
                            long name1 = expenceList.get(j).getFrom().getId();
                            if (name1 == (expenceList.get(i).getTo().getId())) {
                                BigDecimal amount = expenceList.get(i).getAmount();
                                BigDecimal amount1 = expenceList.get(j).getAmount();
                                int value = amount.compareTo(amount1);
                                if (value > 0) {
                                    BigDecimal newAmount = amount.subtract(amount1);
                                    expenceList.get(i).setAmount(newAmount);
                                    expenceList.remove(expenceList.get(j));
                                } else if (value < 0) {
                                    BigDecimal newAmount1 = amount1.subtract(amount);
                                    expenceList.get(j).setAmount(newAmount1);
                                    expenceList.remove(expenceList.get(i));
                                } else {
                                    Expence expence1 = expenceList.get(i);
                                    Expence expence = expenceList.get(j);
                                    expenceList.remove(expence1);
                                    expenceList.remove(expence);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
