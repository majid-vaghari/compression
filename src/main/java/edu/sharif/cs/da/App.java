package edu.sharif.cs.da;

import java.util.Scanner;

/**
 * Command-line tool for this module.
 * <p>
 * Enter window size and message length in the first line as two integers with a space in between.
 * <p>
 * Enter the message in the second line.
 * <p>
 * Sample usage:
 * <pre>
 *     $ java -jar compression.jar
 *     5 10
 *     abcdeacdee
 *
 *     [0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][0, 2][1, 1][0, 1]
 * </pre>
 *
 * @author Majid Vaghari
 */
public class App {
    /**
     * Default look ahead length.
     * <p>
     * Since the default look ahead length is not specified in the project specifications, a default value is assumed
     * that is large enough for reasonable input sizes.
     */
    public static final int DEFAULT_LOOK_AHEAD_BUFFER_LENGTH = 1000;

    /**
     * Main method. Usage of this application is explained in the project specification.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            printHelp();
            return;
        }

        var input              = new Scanner(System.in);
        var searchBufferLength = input.nextInt();
        var messageLength      = input.nextInt();
        input.nextLine(); // ignore the newline character

        var message = input.nextLine().substring(0, messageLength);

        var encoder = Encoder.create(searchBufferLength, DEFAULT_LOOK_AHEAD_BUFFER_LENGTH);

        System.out.println(encoder.encode(message));
    }

    /**
     * Sample usage will be printed if the main method is run with any arguments.
     */
    private static void printHelp() {
        System.out.println("First line:  w and n.");
        System.out.println("             w: window length");
        System.out.println("             n: message length");
        System.out.println("Second line: message with length n");
        System.out.println();
        System.out.println("Sample usage:");
        System.out.println("5 10");
        System.out.println("abcdeacdee");
        System.out.println();
        System.out.println("[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][0, 2][1, 1][0, 1]");

    }
}
