package module;

import java.util.List;

public class Expence {
    Person from;
    List<Person> to;

    public Expence(Person from, List<Person> to) {
        this.from = from;
        this.to = to;
    }
}
