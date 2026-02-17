package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsTest {

    @Test
    void testSameObjectReturnsTrueForEquals() {
        Range r = new Range(1.0, 5.0);
        assertTrue(r.equals(r));
    }

    @Test
    void testEquivalentRangeReturnsTrueForEquals() {
        Range r1 = new Range(1.0, 5.0);
        Range r2 = new Range(1.0, 5.0);
        assertTrue(r1.equals(r2));
    }

    @Test
    void testDifferentLowerReturnsFalseForEquals() {
        Range r1 = new Range(1.0, 5.0);
        Range r2 = new Range(2.0, 5.0);
        assertFalse(r1.equals(r2));
    }

    @Test
    void testDifferentUpperReturnsFalseForEquals() {
        Range r1 = new Range(1.0, 5.0);
        Range r2 = new Range(1.0, 6.0);
        assertFalse(r1.equals(r2));
    }

    @Test
    void testNullReturnsFalseForEquals() {
        Range r = new Range(1.0, 5.0);
        assertFalse(r.equals(null));
    }

    @Test
    void testDifferentTypeReturnsFalseForEquals() {
        Range r = new Range(1.0, 5.0);
        assertFalse(r.equals("not a Range"));
    }
}
