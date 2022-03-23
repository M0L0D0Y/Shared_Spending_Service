package module;

import java.util.List;

public class Session {
    private  long id;
    private  List<Person> persons ;
    private  List<Expence> expenses;

    public Session(long id, List<Person> persons, List<Expence> expenses) {
        this.id = id;
        this.persons = persons;
        this.expenses = expenses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Expence> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expence> expenses) {
        this.expenses = expenses;
    }
}
