package org.jfree.data;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CalculateColumnTotalTest.class, CalculateRowTotalTest.class, CombineTest.class, ConstrainTest.class, ContainsTest.class ,EqualsTest.class, ExpandTest.class,
		ExpandToIncludeTest.class, GetCentralValueTest.class, GetCumulativePercentagesTest.class ,GetLengthTest.class, GetLowerBoundTest.class,
		GetUpperBoundTest.class, IntersectsTest.class, ShiftAllowZeroCrossingTest.class, ShiftTest.class,
		ToStringTest.class, RangeConstructorTest.class, DataUtilitiesTest.class, DataUtilitiesNullInputTest.class })
public class AllTests {

}
