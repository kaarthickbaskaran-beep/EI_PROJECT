package OP;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatApp {
    private static final Logger logger = Logger.getLogger(ChatApp.class.getName());

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        Scanner scanner = new Scanner(System.in);

        try {
            logger.info("Chat application started. Type 'exit' to quit.");

            
            User alice = new User("Alice");
            User bob = new User("Bob");
            chatRoom.addObserver(alice);
            chatRoom.addObserver(bob);

            boolean isRunning = true;
            while (isRunning) {
                try {
                    System.out.print("Enter sender name: ");
                    String sender = scanner.nextLine().trim();

                    System.out.print("Enter message: ");
                    String message = scanner.nextLine().trim();

                    if ("exit".equalsIgnoreCase(message)) {
                        isRunning = false;
                        logger.info("User requested shutdown.");
                    } else if (sender.isEmpty() || message.isEmpty()) {
                        logger.warning("Sender or message cannot be empty.");
                    } else {
                        chatRoom.notifyObservers(sender, message);
                    }
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Unexpected error occurred", e);
                }
            }
        } finally {
            scanner.close();
            logger.info("Chat application terminated.");
        }
    }
}
