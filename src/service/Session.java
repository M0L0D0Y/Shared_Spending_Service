package service;

import module.Expence;
import module.Person;
import service.GenerateId;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session {
    Scanner scanner = new Scanner(System.in);
    private final List<Person> personList = new ArrayList<>();
    private final List<Expence> listExpences = new ArrayList<>();
    GenerateId idGenerate = new GenerateId();
    long id;

    public void addPartaker() {
        System.out.println("Введите имя участника:");
        String name = scanner.nextLine();
        id = idGenerate.generate();
        personList.add(new Person(name, id));
    }

    public void saveExpence() {
        List<Person> listBorrowers = new ArrayList<>();
        System.out.println("Кто расплатился?");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + " " + personList.get(i).getName());
        }
        int choice = scanner.nextInt();
        listBorrowers.add(personList.get(choice - 1));
        personList.remove(listBorrowers.get(0));
        List<Person> listDebtor = new ArrayList<>(personList);
        personList.add(choice - 1, listBorrowers.get(0));
        System.out.println("Какую сумму заплатил?");
        double amount = scanner.nextDouble() / listDebtor.size();
        List<Double> amounts = new ArrayList<>();
        for (int i = 0; i < listDebtor.size(); i++) {
            amounts.add(amount);
        }
        Expence expence = new Expence(listBorrowers.get(0), listDebtor, amounts);
        listExpences.add(expence);
        calculateExpence();
    }

    public void printList() {
        for (Expence listExpence : listExpences) {
            System.out.println(listExpence.getFrom().getName() + " должны " + listExpence.getTo() + " " +
                    listExpence.getAmount() + " по рублей");
        }
    }

    private void calculateExpence() {
        List<Person> borrowers = new ArrayList<>();
        for (Expence listExpence : listExpences) {
            borrowers.add(listExpence.getFrom());//получаем список кредиторов
        }
        for (int i = 0; i < listExpences.size(); i++) {//для каждого кредитора проверяем не является ли он должником
            List<Person> debstor = new ArrayList<>(listExpences.get(i).getTo());//создаем списки должников
            for (int j = 0; j < debstor.size(); j++) {
                if (borrowers.contains(debstor.get(j))) {
                    double expenceDebstore = listExpences.get(i).getAmount().get(j);
                    Person person = listExpences.get(i).getTo().get(j);
                    for (int l = 0; l < listExpences.size(); l++) {
                        if (listExpences.get(l).getFrom().equals(person)) {
                            List<Person> listExpenceBorrower = listExpences.get(l).getTo();
                            for (int k = 0; k < listExpenceBorrower.size(); k++) {
                                if (borrowers.contains(listExpenceBorrower.get(k))) {
                                    double expenceBoroower = listExpences.get(l).getAmount().get(k);
                                    if (expenceDebstore > expenceBoroower) {
                                        double newExpenceDedstore = expenceDebstore - expenceBoroower;
                                        listExpences.get(i).getAmount().set(j, newExpenceDedstore);
                                        List<Double> newListExpenceBorrower = listExpences.get(l).getAmount();
                                        newListExpenceBorrower.remove(k);
                                        if (newListExpenceBorrower.isEmpty()) {
                                            listExpences.remove(l);
                                        } else {
                                            listExpences.get(l).setAmount(newListExpenceBorrower);
                                            List<Person> newList = listExpences.get(l).getTo();
                                            newList.remove(k);
                                            listExpences.get(l).setTo(newList);
                                        }
                                    } else if (expenceDebstore < expenceBoroower) {
                                        double newExpenceBorrower = expenceBoroower - expenceDebstore;
                                        listExpences.get(l).getAmount().set(k,newExpenceBorrower);
                                        List<Double> newListExpenceBorrower = listExpences.get(i).getAmount();
                                        newListExpenceBorrower.remove(j);
                                        if (newListExpenceBorrower.isEmpty()) {
                                            listExpences.remove(i);
                                        } else {
                                            listExpences.get(i).setAmount(newListExpenceBorrower);
                                            List<Person> newList = listExpences.get(i).getTo();
                                            newList.remove(j);
                                            listExpences.get(i).setTo(newList);
                                        }
                                    }else {
                                        List<Person> newList1 = listExpences.get(i).getTo();
                                        newList1.remove(j);
                                        List<Double> newListExpenceBorrower = listExpences.get(i).getAmount();
                                        newListExpenceBorrower.remove(j);
                                        List<Person> newList2 = listExpences.get(l).getTo();
                                        newList2.remove(k);
                                        List<Double> newListExpenceDebstor = listExpences.get(l).getAmount();
                                        newListExpenceDebstor.remove(k);
                                        if (newList1.isEmpty()||newList2.isEmpty()) {
                                            listExpences.remove(j);
                                            listExpences.remove(l);
                                        }else{
                                            listExpences.get(i).setTo(newList1);
                                            listExpences.get(l).setTo(newList2);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
