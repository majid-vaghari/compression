package edu.sharif.cs.da;

import edu.sharif.cs.da.internal.SlidingWindowEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link Encoder} interface.
 */
class EncoderTest {

    /**
     * Test that factory method creates an instance of {@link SlidingWindowEncoder}
     */
    @Test
    void create() {
        var encoder = Encoder.create(10, 20);
        assertTrue(encoder instanceof SlidingWindowEncoder);
    }

    @Test
    void projectSpecificationTest1() {
        var message = "ababcabad";
        var encoder = Encoder.create(10, App.DEFAULT_LOOK_AHEAD_BUFFER_LENGTH);
        assertEquals("[0, 0]a[0, 0]b[0, 2][0, 0]c[0, 3][0, 0]d", encoder.encode(message));
    }

    @Test
    void projectSpecificationTest2() {
        var message = "abcdeacdee";
        var encoder = Encoder.create(5, App.DEFAULT_LOOK_AHEAD_BUFFER_LENGTH);
        assertEquals("[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][0, 2][1, 1][0, 1]", encoder.encode(message));
    }
}