package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateColumnTotalTest {
	private Values2D value;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);
		when(value.getColumnCount()).thenReturn(5);
		when(value.getRowCount()).thenReturn(3);
		when(value.getValue(0, 4)).thenReturn(2);
		when(value.getValue(1, 4)).thenReturn(null);
		when(value.getValue(2, 4)).thenReturn(1);
	}

	@Test
	void testCalculateColumnTotalsWithValues() {
		assertEquals(3,DataUtilities.calculateColumnTotal(value,4));
		verify(value,times(3)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testCalculateColumnTotalWithNegativeColumn() {
		assertEquals(0,DataUtilities.calculateColumnTotal(value, -1));
	}
	
	@Test
	void testCalculateColumnTotalWithColumnAboveMaximum() {
		assertEquals(0,DataUtilities.calculateColumnTotal(value, 5));
	}

	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
