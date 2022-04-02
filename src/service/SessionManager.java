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
            List<Person> listPerson = new ArrayList<>();
            for (Expence item : expenceList) {
                listPerson.add(item.getFrom());
            }
            while (listPerson.contains(person)) {
                listPerson.remove(person);
                for (int i = 0; i < expenceList.size(); i++) {
                    Person creditor = expenceList.get(i).getFrom();
                    for (int j = 0; j < expenceList.size(); j++) {
                        if (creditor.equals(expenceList.get(j).getTo())) {
                            Person debtor = expenceList.get(j).getFrom();
                            if (debtor.equals(expenceList.get(i).getTo())) {
                                BigDecimal amountCreditor = expenceList.get(i).getAmount();
                                BigDecimal amountDebtor= expenceList.get(j).getAmount();
                                int value = amountCreditor.compareTo(amountDebtor);
                                if (value > 0) {
                                    BigDecimal newAmountCreditor = amountCreditor.subtract(amountDebtor);
                                    expenceList.get(i).setAmount(newAmountCreditor);
                                    expenceList.remove(expenceList.get(j));
                                } else if (value < 0) {
                                    BigDecimal newAmountDebstor = amountDebtor.subtract(amountCreditor);
                                    expenceList.get(j).setAmount(newAmountDebstor);
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
