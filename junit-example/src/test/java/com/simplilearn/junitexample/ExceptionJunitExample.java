package com.simplilearn.junitexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionJunitExample {
	
	@Test
	void shouldThrowException() {
		Throwable e = assertThrows(UnsupportedOperationException.class, () -> {
			throw new UnsupportedOperationException ("Operation not supported");
			}
		);
		
		assertEquals("Operation not supported", e.getMessage());

	}
	
	@Test
	void assertThrowsException() {
		String s = null;
		assertThrows(IllegalArgumentException.class, () -> {
			Integer.valueOf(s);
			}
		);
	}

}
