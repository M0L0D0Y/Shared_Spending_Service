package module;

import java.math.BigDecimal;
import java.util.Date;

public class Expence {
    private long id;
    private Person from;
    private Person to;
    private BigDecimal amount;
    private Date dataTime;

    public Expence(long id, Person from, Person to, BigDecimal amount, Date dataTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.dataTime = dataTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }
}
