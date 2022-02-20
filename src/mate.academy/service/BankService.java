package service;

import java.math.BigDecimal;

public interface BankService {
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount);
}
