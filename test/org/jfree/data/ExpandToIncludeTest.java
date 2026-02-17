package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpandToIncludeTest {

    @Test
    void testNullRangeCreatesSinglePointRangeForExpandToInclude() {
        Range result = Range.expandToInclude(null, 5.0);

        assertEquals(5.0, result.getLowerBound(), 0.0000001);
        assertEquals(5.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    void testValueInsideRangeReturnsSameBoundsForExpandToInclude() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expandToInclude(base, 4.0);

        assertEquals(2.0, result.getLowerBound(), 0.0000001);
        assertEquals(6.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    void testValueBelowLowerExpandsLowerOnlyForExpandToInclude() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expandToInclude(base, 1.0);

        assertEquals(1.0, result.getLowerBound(), 0.0000001);
        assertEquals(6.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    void testValueAboveUpperExpandsUpperOnlyForExpandToInclude() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expandToInclude(base, 7.0);

        assertEquals(2.0, result.getLowerBound(), 0.0000001);
        assertEquals(7.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    void testValueAtLowerBoundReturnsSameBoundsForExpandToInclude() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expandToInclude(base, 2.0);

        assertEquals(2.0, result.getLowerBound(), 0.0000001);
        assertEquals(6.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    void testValueAtUpperBoundReturnsSameBoundsForExpandToInclude() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expandToInclude(base, 6.0);

        assertEquals(2.0, result.getLowerBound(), 0.0000001);
        assertEquals(6.0, result.getUpperBound(), 0.0000001);
    }
}
