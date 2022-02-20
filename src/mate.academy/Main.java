import java.math.BigDecimal;
import service.BankService;
import service.BankServiceImpl;

public class Main {
    public static void main(String[] args) {
    BankService bankService = new BankServiceImpl();
    bankService.transfer("1233", "5788", BigDecimal.valueOf(10));
    }
}
