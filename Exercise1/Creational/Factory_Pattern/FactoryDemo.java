package FP;

import java.util.Scanner;
import java.util.logging.Logger;

public class FactoryDemo {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleFactory factory = new VehicleFactory();

        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n=== Vehicle Factory Menu ===");
                System.out.println("1. Create Car");
                System.out.println("2. Create Bike");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> {
                        Vehicle car = factory.createVehicle("car");
                        car.start();
                        car.stop();
                    }
                    case "2" -> {
                        Vehicle bike = factory.createVehicle("bike");
                        bike.start();
                        bike.stop();
                    }
                    case "3" -> {
                        exit = true;
                        logger.info("Exiting Vehicle Factory...");
                    }
                    default -> throw new InvalidInputException("Invalid menu choice. Please select 1, 2, or 3.");
                }

            } catch (InvalidInputException e) {
                logger.severe("Error: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e);
            }
        }
        scanner.close();
    }
}