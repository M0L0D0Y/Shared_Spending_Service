package module;

import java.util.List;
import java.util.Objects;

public class Expence {
    Person from;
    List<Person> to;
    List<Double> amount;

    public Expence(Person from, List<Person> to, List<Double> amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public List<Person> getTo() {
        return to;
    }

    public void setTo(List<Person> to) {
        this.to = to;
    }

    public List<Double> getAmount() {
        return amount;
    }

    public void setAmount(List<Double> amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expence expence = (Expence) o;
        return Objects.equals(amount, expence.amount) &&
                Objects.equals(from, expence.from) &&
                Objects.equals(to, expence.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount);
    }

    @Override
    public String toString() {
        return "Expence{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                '}';
    }
}
