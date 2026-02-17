package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class GetLowerBoundTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testGetLowerBoundMixedValues() {
        Range r = new Range(-42.5, 18.2);
        assertEquals(-42.5, r.getLowerBound());
    }

    @Test
    void testGetLowerBoundPositiveValues() {
        Range r = new Range(4.75, 12.9);
        assertEquals(4.75, r.getLowerBound());
    }

    @Test
    void testGetLowerBoundSinglePoint() {
        Range r = new Range(9.33, 9.33);
        assertEquals(9.33, r.getLowerBound());
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
