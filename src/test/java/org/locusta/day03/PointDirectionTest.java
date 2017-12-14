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

	@Test
	public void test_next_with_diagonal_direction() {
		assertEquals(TOP_RIGHT,    BOTTOM.nextWithDiagonals());
		assertEquals(TOP_LEFT, 	   TOP_RIGHT.nextWithDiagonals());
		assertEquals(BOTTOM_LEFT,  TOP_LEFT.nextWithDiagonals());
		assertEquals(BOTTOM_RIGHT, BOTTOM_LEFT.nextWithDiagonals());
		assertEquals(RIGHT, BOTTOM_RIGHT.nextWithDiagonals());
	}
}
