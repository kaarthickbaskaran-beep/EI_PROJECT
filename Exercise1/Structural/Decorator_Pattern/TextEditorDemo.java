package DP;

import java.util.Scanner;
import java.util.logging.Logger;

public class TextEditorDemo {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        try {
            logger.info("Text Editor started. Type 'exit' at any prompt to quit.");

            while (isRunning) {
                try {
                    System.out.print("\nEnter text: ");
                    String inputText = scanner.nextLine().trim();
                    if ("exit".equalsIgnoreCase(inputText)) {
                        isRunning = false;
                        logger.info("Shutting down Text Editor...");
                        continue;
                    }

                    Text text = new PlainText(inputText);

                    System.out.print("Apply Bold? (y/n): ");
                    String boldChoice = scanner.nextLine().trim();
                    if ("y".equalsIgnoreCase(boldChoice)) {
                        text = new BoldDecorator(text);
                    }

                    System.out.print("Apply Italic? (y/n): ");
                    String italicChoice = scanner.nextLine().trim();
                    if ("y".equalsIgnoreCase(italicChoice)) {
                        text = new ItalicDecorator(text);
                    }

                    System.out.print("Apply Underline? (y/n): ");
                    String underlineChoice = scanner.nextLine().trim();
                    if ("y".equalsIgnoreCase(underlineChoice)) {
                        text = new UnderlineDecorator(text);
                    }

                    System.out.println("Formatted text: " + text.render());

                } catch (Exception e) {
                    logger.severe("Error processing text: " + e.getMessage());
                }
            }

        } finally {
            scanner.close();
            logger.info("Text Editor terminated.");
        }
    }
}