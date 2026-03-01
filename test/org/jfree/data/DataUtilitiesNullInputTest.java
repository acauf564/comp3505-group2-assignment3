package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

public class DataUtilitiesNullInputTest {

    @Test
    public void testCalculateColumnTotalNullDataThrowsNullPointerException() {
        assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.calculateColumnTotal(null, 0);
        });
    }

    @Test
    public void testCalculateRowTotalNullDataThrowsNullPointerException() {
        assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.calculateRowTotal(null, 0);
        });
    }
}