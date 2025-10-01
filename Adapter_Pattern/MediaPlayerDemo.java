package AP;

import java.util.Scanner;
import java.util.logging.Logger;

public class MediaPlayerDemo {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AudioPlayer audioPlayer = new AudioPlayer();
        boolean isRunning = true;

        try {
            logger.info("Media Player started. Type 'exit' at any prompt to quit.");

            while (isRunning) {
                try {
                    System.out.print("\nEnter media type (mp3/mp4): ");
                    String mediaType = scanner.nextLine().trim();
                    if ("exit".equalsIgnoreCase(mediaType)) {
                        isRunning = false;
                        logger.info("Shutting down Media Player...");
                        continue;
                    }

                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine().trim();
                    if ("exit".equalsIgnoreCase(filename)) {
                        isRunning = false;
                        logger.info("Shutting down Media Player...");
                        continue;
                    }

                    
                    if (mediaType.isBlank() || filename.isBlank()) {
                        logger.warning("Media type and filename cannot be blank.");
                        continue;
                    }

                    
                    audioPlayer.play(filename, mediaType);

                } catch (Exception e) {
                    logger.severe("Error playing media: " + e.getMessage());
                }
            }

        } finally {
            scanner.close();
            logger.info("Media Player terminated.");
        }
    }
}