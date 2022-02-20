package service.commission;

import java.math.BigDecimal;

public class UsualCommissionHandler implements CommissionHandler {

    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return new BigDecimal(10);
    }
}
