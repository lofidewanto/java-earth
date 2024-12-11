package com.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoopExamplesTest {

	LoopExamples examples;

	@BeforeEach
	void createCleanClassUnderTest() {
		examples = new LoopExamples();
	}

	@Test
	void testForLoop() {
		examples.forLoop();
	}

	@Test
	void testWhileLoop() {
		Integer result = examples.whileLoop();
		assertEquals(5, result);
	}

}
