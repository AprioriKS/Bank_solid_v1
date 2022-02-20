package service;

import dao.AccountDao;
import db.Storage;
import model.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createNewAccount(String accountNumber) {
        Account account = new Account();
        account.setNumber(accountNumber);
        accountDao.add(account);
    }
}
