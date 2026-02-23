package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateRowTotalTest {

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
	void testCalculateRowTotalWithValues() {
		assertEquals(2,DataUtilities.calculateRowTotal(value,0));
		verify(value,times(5)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testCalculateRowTotalWithNegativeRow() {
		assertEquals(0,DataUtilities.calculateRowTotal(value, -1));
	}
	
	@Test
	void testCalculateRowTotalWithRowAboveMaximum() {
		assertEquals(0,DataUtilities.calculateRowTotal(value, 5));
	}

	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}

