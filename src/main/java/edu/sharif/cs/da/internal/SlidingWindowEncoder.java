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

package edu.sharif.cs.da.internal;

import edu.sharif.cs.da.Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private int           searchBufferLength;
    /**
     * Current message being compressed.
     */
    private String        message;
    /**
     * A list that's being used to track recurrences of current character in input message.
     */
    private List<Integer> recurrences;

    public SlidingWindowEncoder(int searchBufferLength) {
        this.searchBufferLength = searchBufferLength;
        recurrences = new ArrayList<>(searchBufferLength);
    }

    /**
     * @param message {@link String} input message in a simple string.
     *
     * @return {@link String} the compressed message in a simple string
     */
    @Override
    public String encode(String message) {
        this.message = message; // save the message to use in other methods.

        var result = new StringBuilder(); // used to append chunks of compressed message in each step.

        int len; // this is the length of the longest token that is repeated.
        for (var cur = 0; cur < message.length(); cur += len == 0 ? 1 : len) {
            recurrences.clear();

            len = -1; // this is the length of the longest token that is repeated.

            int index; // this is the index of the longest token that is repeated.
            // we look for repeated tokens in the search buffer. the length of the search buffer is given.

            //noinspection StatementWithEmptyBody
            while ((index = getRecurrences(cur, ++len)) == -1) ; // run this function until it finds the appropriate
            // index for the longest token.

            if (index == 0 && len == 0) result.append(String.format("[%d, %d]%s", index, len, message.charAt(cur)));
            else result.append(String.format("[%d, %d]", index, len));
        }
        return result.toString();
    }

    /**
     * This method scans the input message given the current character being scanned and the length of the token that
     * needs to be matched. If the token is found it returns -1 so that the
     * {@link SlidingWindowEncoder#encode(String)} function knows to call it once more; otherwise, it returns the
     * index to the longest token.
     *
     * @param cur int current character being scanned from input message.
     * @param len int length of the token. for example if a 2-character token was matched in the previous run, a
     *            3-character match must be made in this one. if it's not successful, the previous 2-character match
     *            was the longest match possible so its index must be returned.
     *
     * @return int the index to the longest token if it's available. -1 otherwise.
     */
    private int getRecurrences(int cur, int len) {
        if (recurrences.isEmpty()) {
            for (var scan = cur - searchBufferLength > 0 ? cur - searchBufferLength : 0; scan < cur; scan++) {
                if (message.charAt(scan) == message.charAt(cur))
                    recurrences.add(scan);
            }
            if (recurrences.isEmpty()) // no match found
                return 0;
            else return -1;
        } else {
            var firstRecurrence = recurrences.stream().findFirst().get(); // save first recurrence so that if all
            // recurrences are removed, we use this one.
            try {
                recurrences = recurrences
                        .stream()
                        .filter(recurrence -> message.charAt(recurrence + len) == message.charAt(cur + len))
                        .collect(Collectors.toList()); // only keep the tokens that match the current token
            } catch (IndexOutOfBoundsException ignored) { // end of message reached
                return firstRecurrence;
            }
            if (recurrences.isEmpty()) return firstRecurrence;
            else return -1;
        }
    }
}
