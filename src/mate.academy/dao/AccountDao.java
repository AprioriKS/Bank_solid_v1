package dao;

import model.Account;

public interface AccountDao {
    public void add(Account account);
    public Account get(String accountNumber);
    void update(Account account);
}
