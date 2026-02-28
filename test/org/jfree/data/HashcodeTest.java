package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashcodeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testEquivalentRangesHaveSameHash() {
		Range r1 = new Range(1.0,5.0);
		Range r2 = new Range(1.0,5.0);
		var hash1 = r1.hashCode();
		var hash2 = r2.hashCode();
		assertEquals(hash1, hash2);
	}
	
	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
