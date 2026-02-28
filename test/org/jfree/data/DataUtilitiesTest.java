package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

public class DataUtilitiesTest {

    @Test
    public void testCreateNumberArrayNullThrowsException() {
        assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.createNumberArray(null);
        });
    }
    
    @Test
    public void testCreateNumberArrayValidInput() {
        double[] data = {1.5, 0.0, -2.0};
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull(result);
        assertEquals(3, result.length);
        assertEquals(1.5, result[0].doubleValue(), 0.0000001);
        assertEquals(0.0, result[1].doubleValue(), 0.0000001);
        assertEquals(-2.0, result[2].doubleValue(), 0.0000001);
    }
    
    @Test
    public void testCreateNumberArray2DNullThrowsException() {
        assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.createNumberArray2D(null);
        });
    }

    @Test
    public void testCreateNumberArray2DValidInput() {
        double[][] data = {
            {1.0, 2.0},
            {-3.5, 0.0, 4.2}
        };

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertNotNull(result);
        assertEquals(2, result.length);

        // row 0
        assertEquals(2, result[0].length);
        assertEquals(1.0, result[0][0].doubleValue(), 0.0000001);
        assertEquals(2.0, result[0][1].doubleValue(), 0.0000001);

        // row 1
        assertEquals(3, result[1].length);
        assertEquals(-3.5, result[1][0].doubleValue(), 0.0000001);
        assertEquals(0.0, result[1][1].doubleValue(), 0.0000001);
        assertEquals(4.2, result[1][2].doubleValue(), 0.0000001);
    }
    
    @Test
    public void testCreateNumberArray2DContainsNullRowThrowsException() {
        double[][] data = new double[2][];
        data[0] = new double[] {1.0, 2.0};
        data[1] = null;

        assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.createNumberArray2D(data);
        });
    }
    
    @Test
    public void testCreateNumberArrayEmptyInput() {
        double[] data = {};
        Number[] result = DataUtilities.createNumberArray(data);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testCreateNumberArray2DEmptyInput() {
        double[][] data = {};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertNotNull(result);
        assertEquals(0, result.length);
    }


    //Test 2D array with empty inner row
    @Test
    public void testCreateNumberArray2DWithEmptyInnerRow() {
        double[][] data = {
        {1.0, 2.0},
        {},
        {3.5}
        };

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertEquals(3, result.length);
        assertEquals(2, result[0].length);
        assertEquals(0, result[1].length);
        assertEquals(1, result[2].length);
        assertEquals(3.5, result[2][0].doubleValue(), 0.0000001);
    }


    //Test special values in 2D input
    @Test
    public void testCreateNumberArray2DSpecialDoubleValues() {
        
        double[][] data = {
        {Double.NaN},
        {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}
    };

    Number[][] result = DataUtilities.createNumberArray2D(data);

    assertTrue(Double.isNaN(result[0][0].doubleValue()));
    assertEquals(Double.POSITIVE_INFINITY, result[1][0].doubleValue());
    assertEquals(Double.NEGATIVE_INFINITY, result[1][1].doubleValue());
    
    }

    //Test special double values. This checks whether Double.NaN, Double.POSITIVE_INFINITY, and Double.NEGATIVE_INFINITY are preserved correctly.

    @Test
    public void testCreateNumberArraySpecialDoubleValues() {
        double[] data = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        Number[] result = DataUtilities.createNumberArray(data);

        assertEquals(3, result.length);
        assertTrue(Double.isNaN(result[0].doubleValue()));
        assertEquals(Double.POSITIVE_INFINITY, result[1].doubleValue());
        assertEquals(Double.NEGATIVE_INFINITY, result[2].doubleValue());
    }

    
   @Test
    public void testGetCumulativePercentagesHandlesNullValue() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", 1.0);
        data.addValue("B", null);
        data.addValue("C", 3.0);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        assertNotNull(result);
        assertEquals(3, result.getItemCount());

        assertEquals(0.25, result.getValue("A").doubleValue(), 0.0000001);
        assertEquals(0.25, result.getValue("B").doubleValue(), 0.0000001);
        assertEquals(1.0, result.getValue("C").doubleValue(), 0.0000001);
    }

   @Test
    public void testDataUtilitiesConstructor() {
        DataUtilities instance = new DataUtilities() { };
        assertNotNull(instance);
    }
}
