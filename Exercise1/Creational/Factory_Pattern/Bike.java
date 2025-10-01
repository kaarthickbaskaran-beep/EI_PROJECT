package FP;

import java.util.logging.Logger;

public class Bike implements Vehicle {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void start() {
        logger.info("Bike is starting...");
    }

    @Override
    public void stop() {
        logger.info("Bike has stopped.");
    }
}