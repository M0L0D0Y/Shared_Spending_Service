package module;

import java.math.BigDecimal;

public class Expence {
    private long id;
    private String name;
    private Person from;
    private Person to;
    private BigDecimal amount;

    public Expence(long id, String name, Person from, Person to, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
