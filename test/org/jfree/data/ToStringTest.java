package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToStringTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testToStringBasicFormat() {
        Range r = new Range(-4.2, 17.6);
        String s = r.toString();

        assertTrue(s.startsWith("Range["), "Should start with Range[");
        assertTrue(s.endsWith("]"), "Should end with ]");
        assertTrue(s.contains(","), "Should contain a comma between bounds");
    }

    @Test
    void testToStringContainsLowerBound() {
        Range r = new Range(-4.2, 17.6);
        String s = r.toString();

        System.out.println("toString() output: " + s);
        assertTrue(s.contains("-4.2"), "Should include the lower bound value");
    }

    @Test
    void testToStringContainsUpperBound() {
        Range r = new Range(-4.2, 17.6);
        String s = r.toString();

        assertTrue(s.contains("17.6"), "Should include the upper bound value");
    }

    @Test
    void testToStringZeroLengthRange() {
        Range r = new Range(6.66, 6.66);
        String s = r.toString();

        assertTrue(s.contains("6.66"), "Should include the bound value for zero-length range");
        assertTrue(s.startsWith("Range[") && s.endsWith("]"), "Should follow Range[lower,upper] format");
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
