package service;

import dao.AccountDao;
import db.Storage;
import java.math.BigDecimal;
import model.Account;

public class BankServiceImpl implements BankService {
    private AccountDao accountDao;

    public BankServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(fromAccountNumber);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);
    }



}
