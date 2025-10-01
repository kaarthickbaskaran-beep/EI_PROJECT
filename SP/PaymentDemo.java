package SP;

import java.util.Scanner;
import java.util.logging.Logger;

public class PaymentDemo {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();
        boolean isRunning = true;

        try {
            logger.info("Payment system started. Type 'exit' to quit.");

            while (isRunning) {
                try {
                    System.out.println("\n=== Payment Menu ===");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");
                    System.out.println("3. UPI");
                    System.out.println("4. Exit");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine().trim();

                    if ("4".equals(choice) || "exit".equalsIgnoreCase(choice)) {
                        isRunning = false;
                        logger.info("Shutting down payment system...");
                        continue;
                    }

                    System.out.print("Enter amount to pay: ");
                    String amountInput = scanner.nextLine().trim();

                    if ("exit".equalsIgnoreCase(amountInput)) {
                        isRunning = false;
                        logger.info("Shutting down payment system...");
                        continue;
                    }

                    double amount;
                    try {
                        amount = Double.parseDouble(amountInput);
                        if (amount <= 0) {
                            logger.warning("Amount must be positive.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        logger.warning("Invalid number format.");
                        continue;
                    }

                    switch (choice) {
                        case "1" -> context.setPaymentStrategy(new CreditCardPayment());
                        case "2" -> context.setPaymentStrategy(new PayPalPayment());
                        case "3" -> context.setPaymentStrategy(new UpiPayment());
                        default -> {
                            logger.warning("Invalid menu choice.");
                            continue;
                        }
                    }

                    
                    context.pay(amount);

                } catch (Exception e) {
                    logger.severe("Payment failed: " + e.getMessage());
                }
            }

        } finally {
            scanner.close();
            logger.info("Payment system terminated.");
        }
    }
}