package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class RangeConstructorTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testConstructorLowerGreaterThanUpperThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(8.0, 2.0);
        });
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}