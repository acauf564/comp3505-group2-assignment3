package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetCentralValueTest {

    @Test
    void testCentralValueIsMidpointForGetCentralValue() {
        Range r = new Range(2.0, 6.0);
        assertEquals(4.0, r.getCentralValue(), 0.0000001);
    }

    @Test
    void testCentralValueOfSymmetricRangeIsZeroForGetCentralValue() {
        Range r = new Range(-1.0, 1.0);
        assertEquals(0.0, r.getCentralValue(), 0.0000001);
    }

    @Test
    void testCentralValueOfZeroLengthRangeEqualsBoundForGetCentralValue() {
        Range r = new Range(3.0, 3.0);
        assertEquals(3.0, r.getCentralValue(), 0.0000001);
    }
}
