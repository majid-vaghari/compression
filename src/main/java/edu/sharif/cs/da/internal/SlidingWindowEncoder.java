package edu.sharif.cs.da.internal;

import edu.sharif.cs.da.Encoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Default implementation of sliding window text compression.
 *
 * @author Majid Vaghari
 */
public class SlidingWindowEncoder implements Encoder {
    /**
     * The length of the search buffer.
     * <p>
     * The compressor will only look for recurrences in the search buffer.
     */
    private int searchBufferLength;
    /**
     * The length of the look ahead buffer.
     * <p>
     * The compressor will only look for recurrences that are at most as
     * long as the look ahead buffer.
     */
    private int lookAheadBufferLength;

    public SlidingWindowEncoder(int searchBufferLength, int lookAheadBufferLength) {
        this.searchBufferLength = searchBufferLength;
        this.lookAheadBufferLength = lookAheadBufferLength;
    }

    /**
     * @param message {@link BufferedReader} input message in a buffered character stream.
     * @return {@link BufferedWriter} the compressed message in a buffered character stream.
     */
    @Override
    public BufferedWriter encode(BufferedReader message) {
        return null;
    }

    /**
     * Unbuffered version of {@link Encoder#encode(BufferedReader)}.
     *
     * @param message {@link Reader} input message in an unbuffered character stream.
     * @return {@link Writer} the compressed message in an unbuffered character stream.
     */
    @Override
    public Writer encode(Reader message) {
        return null;
    }

    /**
     * @param message {@link String} input message in a simple string.
     * @return {@link String} the compressed message in a simple string
     */
    @Override
    public String encode(String message) {
        return null;
    }
}
