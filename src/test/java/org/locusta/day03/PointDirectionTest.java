package org.locusta.day03;

import static org.junit.Assert.*;
import static org.locusta.day03.PointDirection.*;

import org.junit.Test;

public class PointDirectionTest {

	@Test
	public void test_next_direction() {
		assertEquals(RIGHT,  BOTTOM.next());
		assertEquals(TOP, 	 RIGHT.next());
		assertEquals(LEFT, 	 TOP.next());
		assertEquals(BOTTOM, LEFT.next());
	}

}
