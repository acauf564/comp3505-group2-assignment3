package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DataUtilitiesNullInputTest {

    @Test
    public void testCalculateColumnTotalNullDataThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            DataUtilities.calculateColumnTotal(null, 0);
        });
    }

    @Test
    public void testCalculateRowTotalNullDataThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            DataUtilities.calculateRowTotal(null, 0);
        });
    }
}