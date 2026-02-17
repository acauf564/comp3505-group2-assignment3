package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstrainTest {
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testConstrainBelowRange() {
		Range r = new Range(-150.80,69.69);
		double result = r.constrain(-160.00);
		assertEquals(-150.80,result);
	}
	
	@Test
	void testConstrainOnLowerBound() {
		Range r = new Range(-150.80,69.69);
		double result = r.constrain(-150.80);
		assertEquals(-150.80,result);
	}
	
	@Test
	void testConstrainInRange() {
		Range r = new Range(-150.80,69.69);
		double result = r.constrain(40.0);
		assertEquals(40.0,result);
	}
	
	@Test
	void testConstrainOnUpperBound() {
		Range r = new Range(-150.80,69.69);
		double result = r.constrain(69.69);
		assertEquals(69.69,result);
	}
	
	@Test
	void testConstrainAboveRange() {
		Range r = new Range(-150.80,69.69);
		double result = r.constrain(75.00);
		assertEquals(69.69,result);
	}
	
	@Test
	void testConstrainOnRangeWithSingleValue() {
		Range r = new Range(15.0518,15.0518);
		double result = r.constrain(30);
		assertEquals(15.0518,result);
	}
	
	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
