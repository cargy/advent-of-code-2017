package org.locusta.day03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {

	@Test
	public void test_point_on_all_directions_from_zero_point() {
		Point startingPoint = new Point(0, 0);
		assertEquals(new Point( 1,  0), startingPoint.on(PointDirection.RIGHT));
		assertEquals(new Point( 0, -1), startingPoint.on(PointDirection.TOP));
		assertEquals(new Point(-1,  0), startingPoint.on(PointDirection.LEFT));
		assertEquals(new Point( 0,  1), startingPoint.on(PointDirection.BOTTOM));
	}
	
	@Test
	public void test_next_point_on_left() {
		assertEquals(new Point( 0, -1), new Point(1, -1).on(PointDirection.LEFT));
	}

}
