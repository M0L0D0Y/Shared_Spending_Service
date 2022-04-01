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

    public void addExpence(String name, String from, BigDecimal amount) {// передаем имя траты, кто заплатил и сколько
        List<Person> listDebtor = new ArrayList<>(personList);//чтобы не удалять из сессии создаем копию
        Person payer = null;
        for (int i=0; i< listDebtor.size(); i++){//ищем по имени
            if (listDebtor.get(i).getName().equals(from)){//как находим
                payer = listDebtor.get(i);// получаем его
                listDebtor.remove(payer);// и удаляем из списка
                break;// здесь не уверен в правильности досрочного выхода из цикла
            }
        }
        BigDecimal number = BigDecimal.valueOf(personList.size());//узнаем сколько было участников
        BigDecimal duty = amount.divide(number);//узнаем по сколько должны были все заплатить
        // может сделать какое-то округление?
        for (Person person : listDebtor) {//создаем трату для каждого из должников
            Expence expence = new Expence(generateId.generate(), name, payer, person, duty);
            expenceList.add(expence);//записываем ее в список трат
        }
    }
    public void printExpence(){
        for (Expence expence: expenceList){
            System.out.println(expence);
        }
    }

}
