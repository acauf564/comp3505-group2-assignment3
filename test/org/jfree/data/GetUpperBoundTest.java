package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetUpperBoundTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testGetUpperBoundNormal() {
        Range r = new Range(1.0, 5.0);
        assertEquals(5.0, r.getUpperBound(), 0.0);
    }

    @Test
    void testGetUpperBoundNegativeRange() {
        Range r = new Range(-10.0, -2.0);
        assertEquals(-2.0, r.getUpperBound(), 0.0);
    }

    @Test
    void testGetUpperBoundDecimalRange() {
        Range r = new Range(0.1, 0.9);
        assertEquals(0.9, r.getUpperBound(), 0.0);
    }

    @Test
    void testGetUpperBoundZeroLengthRange() {
        Range r = new Range(3.0, 3.0);
        assertEquals(3.0, r.getUpperBound(), 0.0);
    }
    
    @Test
    void testGetUpperBoundZero() {
        Range r = new Range(-5.0,0.0);
        assertEquals(0.0,r.getUpperBound(), 0.0);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
