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
	void for_loop_example() {
		examples.forLoop();
	}

	@Test
	void while_loop_example() {
		Integer result = examples.whileLoop();
		assertEquals(5, result);
	}

	@Test
	void stream_example() {
		examples.streamApiExample();
	}

}
