package dao;

import db.Storage;
import model.Account;

public class AccountDaoImpl implements AccountDao{
    public void add(Account account) {
        Storage.accounts.add(account);
    }

    public Account get(String accountNumber) {
        return Storage.accounts.stream()
            .filter(a -> a.getNumber().equals(accountNumber))
            .findFirst().get();
    }

    @Override
    public void update(Account account) {
        Account accountFromDb = get(account.getNumber());
        Storage.accounts.remove(accountFromDb);
        add(account);
    }
}
