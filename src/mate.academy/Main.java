import dao.AccountDaoImpl;
import db.Storage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import model.Account.Type;
import service.BankService;
import service.BankServiceImpl;
import service.commission.CommissionHandler;
import service.commission.CommissionStrategy;
import service.commission.CommissionStrategyImpl;
import service.commission.GoldCommissionHandler;
import service.commission.PlatinumCommissionHandler;
import service.commission.RegularCommissionHandler;
import service.commission.UsualCommissionHandler;

public class Main {
    public static void main(String[] args) {
        Map<Type, CommissionHandler> commissionHandlerMap = new HashMap<>();

        startInit(commissionHandlerMap);

        CommissionStrategy commissionStrategy = new CommissionStrategyImpl(commissionHandlerMap);
        BankService bankService = new BankServiceImpl(new AccountDaoImpl(), commissionStrategy);

        bankService.transfer("1233", "5788", BigDecimal.valueOf(1000));
    }

    private static void startInit(Map<Type, CommissionHandler> commissionHandlerMap) {
        Storage.accounts.add(new Account("5788", new BigDecimal(5000), Type.GOLD));
        Storage.accounts.add(new Account("3456", new BigDecimal(10000), Type.PLATINUM));
        Storage.accounts.add(new Account("1233", new BigDecimal(15000), Type.REGULAR));
        Storage.accounts.add(new Account("1245", new BigDecimal(5000), Type.GOLD));

        commissionHandlerMap.put(Type.GOLD, new GoldCommissionHandler());
        commissionHandlerMap.put(Type.PLATINUM, new PlatinumCommissionHandler());
        commissionHandlerMap.put(Type.USUAL, new UsualCommissionHandler());
        commissionHandlerMap.put(Type.REGULAR, new RegularCommissionHandler());
    }
}
