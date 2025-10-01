package FP;

public class VehicleFactory {
    public Vehicle createVehicle(String type) throws InvalidInputException {
        if (type == null || type.isBlank()) {
            throw new InvalidInputException("Vehicle type cannot be empty.");
        }
        switch (type.toLowerCase()) {
            case "car" -> {
                return new Car();
            }
            case "bike" -> {
                return new Bike();
            }
            default -> throw new InvalidInputException("Unknown vehicle type: " + type);
        }
    }
}
