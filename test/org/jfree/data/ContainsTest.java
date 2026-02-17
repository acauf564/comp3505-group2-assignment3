package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainsTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testContainsUpperBoundIsTrue() {
		Range r = new Range(-5.0,16.0);
		assertTrue(r.contains(16.0));
	}
	
	@Test
	void testContainsLowerBoundIsTrue() {
		Range r = new Range(-5.0,16.0);
		assertTrue(r.contains(-5.0));
	}
	
	@Test
	void testContainsAboveUpperBoundIsFalse() {
		Range r = new Range(-5.0,16.0);
		assertFalse(r.contains(25.25));
	}
	
	@Test
	void testContainsBelowLowerBoundIsFalse() {
		Range r = new Range(-5.0,16.0);
		assertFalse(r.contains(-10.50));
	}
	
	@Test
	void testContainsInRangeIsTrue() {
		Range r = new Range(-5.0,16.0);
		assertTrue(r.contains(2.3456));
	}
	
	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}

}
