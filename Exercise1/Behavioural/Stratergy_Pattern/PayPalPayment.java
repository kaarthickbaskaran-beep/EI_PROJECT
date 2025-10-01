package SP;
import java.util.logging.Logger;

public class PayPalPayment implements PaymentStrategy {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void pay(double amount) throws Exception {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        logger.info("Processing PayPal payment of $" + amount);
        Thread.sleep(500);
        logger.info("PayPal payment successful: $" + amount);
    }
}