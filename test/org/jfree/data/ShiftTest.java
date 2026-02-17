package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testShiftPositiveDeltaNoZeroCrossing() {
        Range base = new Range(-7.25, 14.75);
        Range shifted = Range.shift(base, 3.40);

        assertEquals(-3.85, shifted.getLowerBound(), 0.0000001);
        assertEquals(18.15, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftNegativeDeltaNoZeroCrossing() {
        Range base = new Range(8.60, 19.10);
        Range shifted = Range.shift(base, -2.25);

        assertEquals(6.35, shifted.getLowerBound(), 0.0000001);
        assertEquals(16.85, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftCrossesZeroLowerClampedToZero() {
        // Note: shift(base, delta) should NOT allow zero crossing (equivalent to allowZeroCrossing=false)
        Range base = new Range(2.80, 9.30);
        Range shifted = Range.shift(base, -5.10); // would be (-2.30, 4.20) but lower should clamp to 0

        assertEquals(0.0, shifted.getLowerBound(), 0.0000001);
        assertEquals(4.20, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftNullBaseThrowsInvalidParameterException() {
        assertThrows(InvalidParameterException.class, () -> {
            Range.shift(null, 1.23);
        });
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
