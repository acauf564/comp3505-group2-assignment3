package org.jfree.data;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CombineTest.class, ConstrainTest.class, ContainsTest.class, EqualsTest.class, ExpandTest.class,
		ExpandToIncludeTest.class, GetCentralValueTest.class, GetLengthTest.class, GetLowerBoundTest.class,
		GetUpperBoundTest.class, IntersectsTest.class, ShiftAllowZeroCrossingTest.class, ShiftTest.class,
		ToStringTest.class })
public class AllTests {

}
