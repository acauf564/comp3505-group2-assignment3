package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombineTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCombineFullyOverlappingRanges() {
		Range r1 = new Range(-15.75,15.25);
		Range r2 = new Range(13.75,14.00);
		Range result = Range.combine(r1, r2);
		assertEquals(-15.75,result.getLowerBound());
		assertEquals(15.25,result.getUpperBound());
	}
	
	@Test
	void testCombineNotOverlappingRanges() {
		Range r1 = new Range(10.5,30.45);
		Range r2 = new Range(5.5,10);
		Range result = Range.combine(r1, r2);
		assertEquals(5.5,result.getLowerBound());
		assertEquals(30.45,result.getUpperBound());
	}
	
	@Test
	void testCombinePartialOverlappingRanges() {
		Range r1 = new Range(10.0,15.0);
		Range r2 = new Range(5.0,10.0);
		Range result = Range.combine(r1, r2);
		assertEquals(5.0,result.getLowerBound());
		assertEquals(15.0,result.getUpperBound());
	}
	
	@Test
	void testCombineWithFirstRangeNull() {
		Range r1 = null;
		Range r2 = new Range(-15.75,15);
		Range result = Range.combine(r1, r2);
		assertEquals(r2,result);
	}
	
	@Test
	void testCombineWithSecondRangeNull() {
		Range r1 = new Range(1.0,5.0);
		Range r2 = null;
		Range result = Range.combine(r1, r2);
		assertEquals(r1,result);
	}
	
	@Test
	void testCombineWithTwoNullRangesIsNull() {
		Range r1 = null;
		Range r2 = null;
		Range result = Range.combine(r1, r2);
		assertNull(result);
	}
	
	@Test
	void testCombineNotOverlappingZeroWidthRanges() {
		Range r1 = new Range(2.0,2.0);
		Range r2 = new Range(5.0,5.0);
		Range result = Range.combine(r2,r1);
		assertEquals(2.0,result.getLowerBound());
		assertEquals(5.0,result.getUpperBound());
	}

	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
