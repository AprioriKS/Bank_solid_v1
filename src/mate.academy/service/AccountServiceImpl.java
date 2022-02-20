package service;

import dao.AccountDao;
import db.Storage;
import java.math.BigDecimal;
import model.Account;
import model.Account.Type;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createNewAccount(String accountNumber) {
        Account account = new Account("0000", new BigDecimal(0), Type.REGULAR);
        account.setNumber(accountNumber);
        accountDao.add(account);
    }
}
