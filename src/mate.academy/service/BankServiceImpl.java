package service;

import dao.AccountDao;
import db.Storage;
import java.math.BigDecimal;
import model.Account;
import service.commission.CommissionHandler;
import service.commission.CommissionStrategy;

public class BankServiceImpl implements BankService {
    private AccountDao accountDao;
    private CommissionStrategy commissionStrategy;

    public BankServiceImpl(AccountDao accountDao,
        CommissionStrategy commissionStrategy) {
        this.accountDao = accountDao;
        this.commissionStrategy = commissionStrategy;
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(toAccountNumber);

        System.out.println("");
        System.out.println("BEFORE TRANSFER");
        print(fromAccount, toAccount);

        BigDecimal commission = commissionStrategy.get(fromAccount.getType())
            .getCommission(amount);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);

        System.out.println("");
        System.out.println("AFTER TRANSFER");
        print(fromAccount, toAccount);

    }

    private void print(Account fromAccount, Account toAccount) {
        System.out.println("Number: " + fromAccount.getNumber()
            + " value:" + fromAccount.getAmount()
            + " type: " + fromAccount.getType());
        System.out.println("Number: " + toAccount.getNumber()
            + " value:" + toAccount.getAmount()
            + " type: " + toAccount.getType());
    }


}
