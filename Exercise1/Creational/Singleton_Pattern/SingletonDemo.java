package SD;

import java.util.Scanner;
import java.util.logging.Logger;

public class SingletonDemo {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConfigurationManager config = ConfigurationManager.getInstance();

        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n=== Configuration Manager Menu ===");
                System.out.println("1. View Current Config");
                System.out.println("2. Update Theme");
                System.out.println("3. Update Timeout");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                String input = scanner.nextLine().trim();

                switch (input) {
                    case "1" -> config.showConfig();
                    case "2" -> {
                        System.out.print("Enter new theme (Light/Dark): ");
                        String theme = scanner.nextLine().trim();
                        config.setAppTheme(theme);
                    }
                    case "3" -> {
                        System.out.print("Enter timeout (seconds): ");
                        String timeoutStr = scanner.nextLine().trim();
                        if (!timeoutStr.matches("\\d+")) {
                            throw new InvalidInputException("Timeout must be a valid positive number.");
                        }
                        int timeout = Integer.parseInt(timeoutStr);
                        config.setTimeout(timeout);
                    }
                    case "4" -> {
                        exit = true;
                        logger.info("Exiting application gracefully...");
                    }
                    default -> throw new InvalidInputException("Invalid menu choice. Please try again.");
                }
            } catch (InvalidInputException | IllegalArgumentException e) {
                logger.severe("Error: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error occurred: " + e);
            }
        }
        scanner.close();
    }
}
