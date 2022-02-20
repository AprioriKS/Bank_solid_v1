package service.commission;

import static model.Account.*;

public interface CommissionStrategy {
    CommissionHandler get(Type type);

}
