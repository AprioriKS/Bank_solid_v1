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
        Account toAccount = accountDao.get(fromAccountNumber);

        BigDecimal commission = commissionStrategy.get(fromAccount.getType())
            .getCommission(amount);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);
    }



}
