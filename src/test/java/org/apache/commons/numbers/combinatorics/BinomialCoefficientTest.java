package org.apache.commons.numbers.combinatorics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit unit test class
 * Used to verify BinomialCoefficient.value() method
 */
public class BinomialCoefficientTest {
    
    @Test
    @DisplayName("Test C(5,2) = 10")
    public void testNormalCase1() {
        assertEquals(10, BinomialCoefficient.value(5, 2));
    }
    
    @Test
    @DisplayName("Test C(10,3) = 120")
    public void testNormalCase2() {
        assertEquals(120, BinomialCoefficient.value(10, 3));
    }
    
    @Test
    @DisplayName("Test C(6,0) = 1")
    public void testKZero() {
        assertEquals(1, BinomialCoefficient.value(6, 0));
    }
    
    @Test
    @DisplayName("Test C(6,6) = 1")
    public void testKEqualsN() {
        assertEquals(1, BinomialCoefficient.value(6, 6));
    }
    
    @Test
    @DisplayName("Test boundary C(0,0) = 1")
    public void testBoundaryBothZero() {
        assertEquals(1, BinomialCoefficient.value(0, 0));
    }
    
    @Test
    @DisplayName("Test boundary C(1,0) = 1")
    public void testBoundaryN1K0() {
        assertEquals(1, BinomialCoefficient.value(1, 0));
    }
    
    @Test
    @DisplayName("Test boundary C(1,1) = 1")
    public void testBoundaryN1K1() {
        assertEquals(1, BinomialCoefficient.value(1, 1));
    }
    
    @Test
    @DisplayName("Test large value C(20,10) = 184756")
    public void testLargeValue() {
        assertEquals(184756, BinomialCoefficient.value(20, 10));
    }
    
    @Test
    @DisplayName("Test negative n should throw exception (detect injected bug)")
    public void testNegativeN() {
        assertThrows(CombinatoricsException.class, () -> {
            BinomialCoefficient.value(-1, 0);
        });
    }
    
    @Test
    @DisplayName("Test negative k should throw exception")
    public void testNegativeK() {
        assertThrows(CombinatoricsException.class, () -> {
            BinomialCoefficient.value(5, -1);
        });
    }
    
    @Test
    @DisplayName("Test k>n should throw exception")
    public void testKGreaterThanN() {
        assertThrows(CombinatoricsException.class, () -> {
            BinomialCoefficient.value(3, 5);
        });
    }
}