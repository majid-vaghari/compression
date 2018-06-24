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
