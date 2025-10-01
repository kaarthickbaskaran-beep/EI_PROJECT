package OP;

import java.util.Objects;
import java.util.logging.Logger;

public class User implements Observer {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private final String name;

    public User(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    @Override
    public void update(String sender, String message) {
        if (message == null || message.isBlank()) {
            logger.warning("Received empty message for user: " + name);
            return;
        }
        System.out.println("[" + sender + " -> " + name + "]: " + message);
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}