package dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Account.Type;

public class AccountDaoCsvImpl implements AccountDao {
    private static final String FILE_NAME = "database.csv";

    @Override
    public void add(Account account) {
        System.out.println("Nothing");
    }

    @Override
    public Account get(String accountNumber) {
        List<String> accounts = new ArrayList<>();
        try {
            accounts = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file " + FILE_NAME);
        }
        return accounts.stream()
            .filter(line -> line.startsWith(accountNumber))
            .map(this::getFromCsvRow)
            .findFirst().get();
    }

    private Account getFromCsvRow(String line) {
        String[] fields = line.split(",");
        Account account = new Account("0000", new BigDecimal(0), Type.REGULAR);
        account.setNumber(fields[0]);
        account.setAmount(new BigDecimal(fields[1]));
        account.setType((Type.valueOf(fields[2])));
        return account;
    }

    @Override
    public void update(Account account) {

    }
}
