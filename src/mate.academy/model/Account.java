package model;

import java.math.BigDecimal;

public class Account {
    private String number;
    private BigDecimal amount = new BigDecimal(0);

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
