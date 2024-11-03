package com.algonquin.lab4test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.algonquin.lab4.Processing;

public class TestProcessing {
    @Test
    void testBasicHighestNumber() {
    	assertEquals(Processing.processNumbers(1, 2, 3), 3.0);
    }
    
    @Test
    void testATruncated() {
    	// The value for a should be truncated to 1000 and the highest number becomes 2000.0.
    	// Otherwise, the highest value will be a at 4000, which is wrong.
    	assertEquals(Processing.processNumbers(4000.0, 2000.0, 1500.0), 2000.0);
    }
    
    @Test
    void testBTruncated() {
    	// The value for b should be truncated to 2000 and the highest number becomes 2500.0.
    	// Otherwise, the highest value will be a at 6000, which is wrong.
    	assertEquals(Processing.processNumbers(500.0, 6000.0, 2500.0), 2500.0);
    }
    
    @Test
    void testCTruncated() {
    	// The value for c should be truncated to 3000 and that becomes the highest number.
    	// Otherwise, the highest value will be a at 5000, which is wrong.
    	assertEquals(Processing.processNumbers(500.0, 1500.0, 5000.0), 3000.0);
    }
    
    @Test
    void testAPositiveInfinity() {
    	// The value for a should be truncated to 1000 and the highest number becomes 2000.0.
    	// Otherwise, the highest value will be a at 4000, which is wrong.
    	assertEquals(Processing.processNumbers(Double.POSITIVE_INFINITY, 2000.0, 1500.0), 2000.0);
    }
    
    @Test
    void testBPositiveInfinity() {
    	// The value for b should be truncated to 2000 and the highest number becomes 2500.0.
    	// Otherwise, the highest value will be a at 6000, which is wrong.
    	assertEquals(Processing.processNumbers(500.0, Double.POSITIVE_INFINITY, 2500.0), 2500.0);
    }
    
    @Test
    void testCPositiveInfinity() {
    	// The value for c should be truncated to 3000 and that becomes the highest number.
    	// Otherwise, the highest value will be a at 5000, which is wrong.
    	assertEquals(Processing.processNumbers(500.0, 1500.0, Double.POSITIVE_INFINITY), 3000.0);
    }
    
    @Test
    void testANotANumber() {
    	try {
    		Processing.processNumbers(Double.NaN, 0.0, 0.0);
    		fail("Processing was done on value a that was not a number.");
    	} catch (IllegalArgumentException ex) {
    		assertEquals(ex.getMessage(), "All values must be numbers");
    	}
    }
    
    @Test
    void testBNotANumber() {
    	try {
    		Processing.processNumbers(0.0, Double.NaN, 0.0);
    		fail("Processing was done on value a that was not a number.");
    	} catch (IllegalArgumentException ex) {
    		assertEquals(ex.getMessage(), "All values must be numbers");
    	}
    }
    
    @Test
    void testCNotANumber() {
    	try {
    		Processing.processNumbers(0.0, 0.0, Double.NaN);
    		fail("Processing was done on value a that was not a number.");
    	} catch (IllegalArgumentException ex) {
    		assertEquals(ex.getMessage(), "All values must be numbers");
    	}
    }
}
