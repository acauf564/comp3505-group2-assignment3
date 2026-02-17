package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class GetLengthTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
		@Test
	    void getLength_normalRange() {
	        Range r = new Range(1, 5);
	        assertEquals(4.0, r.getLength(), 0.0);
	    }

	    @Test
	    void getLength_zeroLengthRange() {
	        Range r = new Range(3, 3);
	        assertEquals(0.0, r.getLength(), 0.0);
	    }

	    @Test
	    void getLength_negativeBounds() {
	        Range r = new Range(-5, -1);
	        assertEquals(4.0, r.getLength(), 0.0);
	    }

	    @Test
	    void getLength_decimalBounds() {
	        Range r = new Range(1.5, 2.0);
	        assertEquals(0.5, r.getLength(), 0.0);
	    }

	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}

}
