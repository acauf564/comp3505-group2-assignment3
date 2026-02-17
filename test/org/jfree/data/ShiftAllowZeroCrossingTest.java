package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ShiftAllowZeroCrossingTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testShiftAllowZeroCrossingTrueNegativeShift() {
        Range r = new Range(6.0, 10.0);
        Range shifted = Range.shift(r, -8.0, true);

        assertEquals(-2.0, shifted.getLowerBound(), 0.0000001);
        assertEquals(2.0, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftAllowZeroCrossingFalseNegativeShift() {
        Range r = new Range(6.0, 10.0);
        Range shifted = Range.shift(r, -8.0, false);

        assertEquals(0.0, shifted.getLowerBound(), 0.0000001);
        assertEquals(0.0, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftAllowZeroCrossingTruePositiveShift() {
        Range r = new Range(-9.0, -4.0);
        Range shifted = Range.shift(r, 7.0, true);

        assertEquals(-2.0, shifted.getLowerBound(), 0.0000001);
        assertEquals(3.0, shifted.getUpperBound(), 0.0000001);
    }

    @Test
    void testShiftAllowZeroCrossingFalsePositiveShift() {
        Range r = new Range(-9.0, -4.0);
        Range shifted = Range.shift(r, 7.0, false);

        assertEquals(0.0, shifted.getLowerBound(), 0.0000001);
        assertEquals(0.0, shifted.getUpperBound(), 0.0000001);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
