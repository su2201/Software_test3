package org.apache.commons.numbers.combinatorics;

/**
 * Manual test class - without JUnit framework
 * Used to verify BinomialCoefficient.value() method
 */
public class BinomialCoefficientManualTest {
    
    private static int testCount = 0;
    private static int passCount = 0;
    private static int failCount = 0;
    
    public static void main(String[] args) {
        System.out.println("========== Manual Test Start ==========");
        System.out.println();
        
        testNormalCases();
        testBoundaryCases();
        testExceptionCases();
        
        System.out.println();
        System.out.println("========== Test Result Summary ==========");
        System.out.println("Total tests: " + testCount);
        System.out.println("Passed: " + passCount);
        System.out.println("Failed: " + failCount);
        System.out.println("Pass rate: " + (testCount > 0 ? (passCount * 100.0 / testCount) : 0) + "%");
    }
    
    private static void testNormalCases() {
        System.out.println("--- Test Normal Cases ---");
        
        testEquals("C(5,2) should be 10", 
            BinomialCoefficient.value(5, 2), 10);
        
        testEquals("C(10,3) should be 120", 
            BinomialCoefficient.value(10, 3), 120);
        
        testEquals("C(6,0) should be 1", 
            BinomialCoefficient.value(6, 0), 1);
        
        testEquals("C(6,6) should be 1", 
            BinomialCoefficient.value(6, 6), 1);
        
        System.out.println();
    }
    
    private static void testBoundaryCases() {
        System.out.println("--- Test Boundary Cases ---");
        
        testEquals("C(0,0) should be 1", 
            BinomialCoefficient.value(0, 0), 1);
        
        testEquals("C(1,0) should be 1", 
            BinomialCoefficient.value(1, 0), 1);
        
        testEquals("C(1,1) should be 1", 
            BinomialCoefficient.value(1, 1), 1);
        
        testEquals("C(20,10) should be 184756", 
            BinomialCoefficient.value(20, 10), 184756);
        
        System.out.println();
    }
    
    private static void testExceptionCases() {
        System.out.println("--- Test Exception Cases (Detect Injected Bug) ---");
        
        testException("C(-1,0) should throw exception (detect bug)", -1, 0);
        testException("C(5,-1) should throw exception", 5, -1);
        testException("C(3,5) should throw exception", 3, 5);
        
        System.out.println();
    }
    
    private static void testEquals(String description, long actual, long expected) {
        testCount++;
        if (actual == expected) {
            System.out.println("[PASS] " + description);
            passCount++;
        } else {
            System.out.println("[FAIL] " + description + " (expected: " + expected + ", actual: " + actual + ")");
            failCount++;
        }
    }
    
    private static void testException(String description, int n, int k) {
        testCount++;
        try {
            long result = BinomialCoefficient.value(n, k);
            System.out.println("[FAIL] " + description + " - actual returned: " + result + " (should throw exception)");
            failCount++;
        } catch (CombinatoricsException e) {
            System.out.println("[PASS] " + description + " - threw exception: " + e.getMessage());
            passCount++;
        } catch (Exception e) {
            System.out.println("[PASS] " + description + " - threw exception: " + e.getClass().getSimpleName());
            passCount++;
        }
    }
}