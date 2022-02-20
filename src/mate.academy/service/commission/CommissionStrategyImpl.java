package service.commission;

import java.util.Map;
import model.Account;
import model.Account.Type;

public class CommissionStrategyImpl implements CommissionStrategy {
    private Map<Type, CommissionHandler> commissionHandlerMap;

    public CommissionStrategyImpl(
        Map<Type, CommissionHandler> commissionHandlerMap) {
        this.commissionHandlerMap = commissionHandlerMap;
    }

    @Override
    public CommissionHandler get(Account.Type type) {
        return commissionHandlerMap.get(type);
    }
}
