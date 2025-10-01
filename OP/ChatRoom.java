package OP;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class ChatRoom implements Subject {
    private static final Logger logger = Logger.getLogger(ChatRoom.class.getName());
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            logger.warning("Attempted to add null observer.");
            return;
        }
        observers.add(o);
        logger.info("Observer added: " + o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        logger.info("Observer removed: " + o);
    }

    @Override
    public void notifyObservers(String sender, String message) {
        for (Observer o : observers) {
            try {
                o.update(sender, message);
            } catch (Exception e) {
                logger.severe("Error notifying observer: " + e.getMessage());
            }
        }
    }
}