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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link Encoder} interface.
 *
 * @author Majid Vaghari
 */
class EncoderTest {

    /**
     * Test that factory method creates an instance of {@link SlidingWindowEncoder}
     */
    @Test
    void create() {
        var encoder = Encoder.create(10);
        assertTrue(encoder instanceof SlidingWindowEncoder);
    }

    @Test
    void projectSpecificationTest1() {
        var message = "ababcabad";
        var encoder = Encoder.create(10);
        assertEquals("[0, 0]a[0, 0]b[0, 2][0, 0]c[0, 3][0, 0]d", encoder.encode(message));
    }

    /**
     * This test seems wrong!
     * <p>
     * It appears that the correct output for this message should be this:
     *
     * <pre>
     *     [0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]
     * </pre>
     * <p>
     * But this is the output expected in the project specification:
     *
     * <pre>
     *     [0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][0, 2][1, 1][0, 1]
     * </pre>
     */
    @Test
    void projectSpecificationTest2() {
        var message = "abcdeacdee";
        var encoder = Encoder.create(5);
        assertEquals("[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]", encoder.encode(message));
    }
}