package FP;

import java.util.logging.Logger;

public class Car implements Vehicle {
    private static final Logger logger = AppLogger.getLogger();

    @Override
    public void start() {
        logger.info("Car is starting...");
    }

    @Override
    public void stop() {
        logger.info("Car has stopped.");
    }
}
