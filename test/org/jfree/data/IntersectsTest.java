package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class IntersectsTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testIntersectsPartialOverlap() {
        Range r = new Range(2.0, 8.0);
        assertTrue(r.intersects(6.0, 11.0));
    }

    @Test
    void testIntersectsFullyContained() {
        Range r = new Range(2.0, 8.0);
        assertTrue(r.intersects(3.0, 7.0));
    }

    @Test
    void testIntersectsTouchingLowerEdge() {
        Range r = new Range(2.0, 8.0);
        assertTrue(r.intersects(-1.0, 2.0));
    }

    @Test
    void testIntersectsTouchingUpperEdge() {
        Range r = new Range(2.0, 8.0);
        assertTrue(r.intersects(8.0, 12.0));
    }

    @Test
    void testIntersectsCompletelyBelow() {
        Range r = new Range(2.0, 8.0);
        assertFalse(r.intersects(-10.0, 1.0));
    }

    @Test
    void testIntersectsCompletelyAbove() {
        Range r = new Range(2.0, 8.0);
        assertFalse(r.intersects(9.0, 15.0));
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
