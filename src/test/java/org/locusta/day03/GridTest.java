package org.locusta.day03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	
	private Grid grid;

	@Before
	public void setup() {
		grid = new Grid();
	}

	@Test
	public void test_next_point() {
		assertEquals(new Point( 1, 0), grid.nextPoint());
		assertEquals(new Point( 1,-1), grid.nextPoint());
		assertEquals(new Point( 0,-1), grid.nextPoint());
		assertEquals(new Point(-1,-1), grid.nextPoint());
		assertEquals(new Point(-1, 0), grid.nextPoint());
		assertEquals(new Point(-1, 1), grid.nextPoint());
		assertEquals(new Point( 0, 1), grid.nextPoint());
		assertEquals(new Point( 1, 1), grid.nextPoint());
	}
	
	@Test
	public void test_get_point() {
		assertEquals(new Point(0, 0), grid.getPoint(1));
		assertEquals(new Point(2,-1), grid.getPoint(12));
		assertEquals(new Point(0, 2), grid.getPoint(23));
	}
	
	@Test
	public void test_steps_to_point() {
		assertEquals(0, grid.stepsTo(1));
		assertEquals(3, grid.stepsTo(12));
		assertEquals(2, grid.stepsTo(23));
		assertEquals(31, grid.stepsTo(1024));
		assertEquals(430, grid.stepsTo(312051));
	}

}
