package SP;
public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) throws Exception {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set.");
        }
        strategy.pay(amount);
    }
}