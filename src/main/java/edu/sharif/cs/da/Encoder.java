package edu.sharif.cs.da;

import edu.sharif.cs.da.internal.SlidingWindowEncoder;

/**
 * Basic interface that encodes a message given in a java.io.BufferedReader and
 * writes the result in a java.io.BufferedWriter.
 * Simply use the {@link Encoder#create(int)} method to make a new instance of the
 * appropriate compressing class and provide the message in the form you like.
 * <p>
 * Sample usage:
 * <pre>
 *     var message = "ababcabad";
 *     var encoder = Encoder.create(10, 10);
 *     System.out.println(encoder.encode(message));
 *     // prints [0, 0]a[0, 0]b[0, 2][0, 0]c[0, 3][0, 0]d
 * </pre>
 *
 * @author Majid Vaghari
 * @version 1.0
 */
public interface Encoder {
    /**
     * @param searchBufferLength    int length of the "window". maximum length which will be
     *                              searched by the compressor for recurrences of characters.
     * @return {@link Encoder} a new instance of sliding window text compressor
     * which is a basic implementation of LZ77 algorithm.
     */
    static Encoder create(int searchBufferLength) {
        return new SlidingWindowEncoder(searchBufferLength);
    }

    /**
     * @param message {@link String} input message in a simple string.
     *
     * @return {@link String} the compressed message in a simple string
     */
    String encode(String message);
}
