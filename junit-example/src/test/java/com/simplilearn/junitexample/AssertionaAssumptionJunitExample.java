package com.simplilearn.junitexample;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertionaAssumptionJunitExample {

	@Test
	void assertionTrueTest() {
		List<Integer> numbers = Arrays.asList (1,2,3);
		assertTrue(numbers.stream().mapToInt(Integer::intValue).sum() > 5, ()-> "Sum > 5");
	}
	
	@Test
	void assertionFalseTest() {
		List<Integer> numbers = Arrays.asList (1,2,3);
		assertFalse(numbers.stream().mapToInt(Integer::intValue).sum() < 5, ()-> "Sum Not > 5");
	}
	
	@Test
	void assertionTest() {
		List<Integer> numbers = Arrays.asList (1,2,3);
		assertFalse(numbers.stream().mapToInt(Integer::intValue).sum() < 5);
	}
	
	@Test
	void groupAssertionTest() {
		int[] numbers = {0,1,2,3,4,5};
		assertAll("numbers",
				() -> assertEquals(numbers[0], 0), // check if array entry 0 equal to value 0.
				() -> assertEquals(numbers[1], 1),
				() -> assertEquals(numbers[3], 3)
		);
	}
	
	@Test
	void testTrueAssumption() {
		assumeTrue(5 > 1);
		assertEquals(5 + 2 , 7);
	}
	
	@Test
	void testFalseAssumption() {
		assumeTrue(5 < 1);
		assertEquals(5 + 2 , 7);
	}	
	
	@Test
	// assumingThat test will not cause test to fail event if the subsequent assert test fails.
	void testAssumingThatAssumption() {
		String a = "Junits are awesome";
		assumingThat(a.contentEquals("Junits are awesome"), () -> assertEquals(2+2, 4));
	}
}
