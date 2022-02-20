import dao.AccountDaoImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
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

        commissionHandlerMap.put(Type.GOLD, new GoldCommissionHandler());
        commissionHandlerMap.put(Type.PLATINUM, new PlatinumCommissionHandler());
        commissionHandlerMap.put(Type.USUAL, new UsualCommissionHandler());
        commissionHandlerMap.put(Type.REGULAR, new RegularCommissionHandler());

        CommissionStrategy commissionStrategy = new CommissionStrategyImpl(commissionHandlerMap);
        BankService bankService = new BankServiceImpl(new AccountDaoImpl(), commissionStrategy);

        bankService.transfer("1233", "5788", BigDecimal.valueOf(1000));
    }
}
