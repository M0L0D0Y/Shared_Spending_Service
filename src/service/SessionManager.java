package service;

import module.Expence;
import module.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Long> listId = new HashSet<>();
        for (Expence item : expenceList) {
            listId.add(item.getFrom().getId());
        }
        List<Long> idPerson = new ArrayList<>(listId);
        for (Long id : idPerson) {
            while (listId.contains(id)) {
                listId.remove(id);
                for (int i = 0; i < expenceList.size(); i++) {
                    long idCreditor = expenceList.get(i).getFrom().getId();
                    for (int j = 0; j < expenceList.size(); j++) {
                        if (idCreditor == (expenceList.get(j).getTo().getId())) {
                            long idDebtor = expenceList.get(j).getFrom().getId();
                            if (idDebtor == (expenceList.get(i).getTo().getId())) {
                                BigDecimal amountCreditor = expenceList.get(i).getAmount();
                                BigDecimal amountDebtor = expenceList.get(j).getAmount();
                                int value = amountCreditor.compareTo(amountDebtor);
                                if (value > 0) {
                                    BigDecimal newAmount = amountCreditor.subtract(amountDebtor);
                                    expenceList.get(i).setAmount(newAmount);
                                    expenceList.remove(expenceList.get(j));
                                } else if (value < 0) {
                                    BigDecimal newAmount1 = amountDebtor.subtract(amountCreditor);
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
