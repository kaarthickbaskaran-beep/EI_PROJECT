package SP;

public interface PaymentStrategy {
    void pay(double amount) throws Exception;
}