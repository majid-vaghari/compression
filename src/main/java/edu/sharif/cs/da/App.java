/*
 * Copyright (c) 2018 Majid Vaghari
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
 *     [0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]
 * </pre>
 *
 * @author Majid Vaghari
 */
public class App {
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

        var encoder = Encoder.create(searchBufferLength);

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
        System.out.println("[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]");

    }
}
