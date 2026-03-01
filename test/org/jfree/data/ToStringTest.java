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
    void testToStringRespectsFormatting() {
        Range r = new Range(-4.2, 17.6);
        assertEquals("Range[-4.2,17.6]", r.toString());
    }

    @Test
    void testToStringZeroLengthRange() {
        Range r = new Range(6.66, 6.66);
        assertEquals("Range[6.66,6.66]", r.toString());
    } 

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}
