package org.jfree.data;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CalculateColumnTotalTest.class, CalculateRowTotalTest.class, DataUtilitiesNullInputTest.class, DataUtilitiesTest.class,
		GetCumulativePercentagesTest.class })
public class DataUtilitiesTests {

}
