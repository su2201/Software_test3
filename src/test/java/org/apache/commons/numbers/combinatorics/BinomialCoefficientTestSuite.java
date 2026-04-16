package org.apache.commons.numbers.combinatorics;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test suite - run all test classes at once
 */
@Suite
@SuiteDisplayName("Binomial Coefficient Test Suite")
@SelectClasses({
    BinomialCoefficientTest.class
})
public class BinomialCoefficientTestSuite {
    // No additional code needed
}