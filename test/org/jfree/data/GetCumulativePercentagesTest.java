package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetCumulativePercentagesTest {

	private KeyedValues values;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		values = mock(KeyedValues.class);
		when(values.getKey(0)).thenReturn(0.0);
		when(values.getKey(1)).thenReturn(5.0);
		when(values.getKey(2)).thenReturn(6.0);
		when(values.getValue(0.0)).thenReturn(1.0);
		when(values.getValue(5.0)).thenReturn(3.0);
		when(values.getValue(6.0)).thenReturn(4.0);
		when(values.getItemCount()).thenReturn(3);
	}
	
	@Test
	void testNullParameter() {
		assertThrows(InvalidParameterException.class, ()-> {
			DataUtilities.getCumulativePercentages(null);
		});
	}
	
	@Test
	void testOnlyPositiveValues() {
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.125,result.getValue(0.0));
		assertEquals(0.5,result.getValue(5.0));
		assertEquals(1.0, result.getValue(6.0));
	}
	
	@Test
	void testWithNegativeValue() {
		values = mock(KeyedValues.class);
		when(values.getKey(0)).thenReturn(0.0);
		when(values.getKey(1)).thenReturn(5.0);
		when(values.getKey(2)).thenReturn(6.0);
		when(values.getValue(0.0)).thenReturn(-2.0);
		when(values.getValue(5.0)).thenReturn(6.0);
		when(values.getValue(6.0)).thenReturn(4.0);
		when(values.getItemCount()).thenReturn(3);
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(-0.25, result.getValue(0.0));
		assertEquals(0.5, result.getValue(5.0));
		assertEquals(1.0, result.getValue(6.0));
	}
	
	@Test
	void testNullValueDoesNotModifyTotal() {
		values = mock(KeyedValues.class);
		when(values.getKey(0)).thenReturn(0.0);
		when(values.getKey(1)).thenReturn(5.0);
		when(values.getKey(2)).thenReturn(6.0);
		when(values.getValue(0.0)).thenReturn(2.0);
		when(values.getValue(5.0)).thenReturn(null);
		when(values.getValue(6.0)).thenReturn(4.0);
		when(values.getItemCount()).thenReturn(3);
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals((double)1/3, result.getValue(0.0));
		assertEquals((double)1/3, result.getValue(5.0));
		assertEquals(1.0, result.getValue(6.0));
	}
	
	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
