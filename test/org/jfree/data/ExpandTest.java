package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class ExpandTest {

    @Test
    void testExpandWithExampleMarginsReturnsExpectedRangeForExpand() {
        Range base = new Range(2.0, 6.0);

        Range expanded = Range.expand(base, 0.25, 0.5);

        assertEquals(1.0, expanded.getLowerBound(), 0.0000001);
        assertEquals(8.0, expanded.getUpperBound(), 0.0000001);
    }

    @Test
    void testExpandWithZeroMarginsReturnsSameRangeForExpand() {
        Range base = new Range(2.0, 6.0);

        Range expanded = Range.expand(base, 0.0, 0.0);

        assertEquals(2.0, expanded.getLowerBound(), 0.0000001);
        assertEquals(6.0, expanded.getUpperBound(), 0.0000001);
    }

    @Test
    void testExpandWithNullRangeThrowsInvalidParameterExceptionForExpand() {
        assertThrows(InvalidParameterException.class, () -> {
            Range.expand(null, 0.25, 0.5);
        });
    }

    @Test
    void testExpandZeroLengthRangeRemainsSameForExpand() {
        Range base = new Range(3.0, 3.0); // length = 0

        Range expanded = Range.expand(base, 0.25, 0.5);

        assertEquals(3.0, expanded.getLowerBound(), 0.0000001);
        assertEquals(3.0, expanded.getUpperBound(), 0.0000001);
    }

    @Test
    void testExpandWithNegativeMarginsReturnsShrunkenRangeForExpand() {
        Range base = new Range(2.0,6.0);
        Range expanded = Range.expand(base, -0.5, 0.0);
        
        assertEquals(4.0, expanded.getLowerBound(), .0000001);
        assertEquals(6.0, expanded.getUpperBound(), .0000001);
    }
    
    @Test
    void testExpandWithMarginsGreaterOrEqualToOne() {
        Range base = new Range(2.0,6.0);
        Range expanded = Range.expand(base, 2.0, 1.0);
        
        assertEquals(-6.0, expanded.getLowerBound(), .0000001);
        assertEquals(10.0, expanded.getUpperBound(), .0000001);
    }

}
