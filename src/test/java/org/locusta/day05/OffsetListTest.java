package org.locusta.day05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class OffsetListTest {
	
	private IncreasableOffsetList message = new IncreasableOffsetList(Arrays.asList(0, 1, 2, 3, 4));

	@Test
	public void test_jumping_zero_steps() {
		Integer previous = message.getCurrent();
		message.jump(0);
		assertEquals(new Integer(previous + 1) , message.getCurrent());
	}
	
	@Test
	public void test_jumping_forward() {
		assertTrue(message.jump(1));
		assertEquals(new Integer(1), message.getCurrent());
	}

	@Test
	public void test_jumping_backward() {
		message.jump(1);
		assertEquals(new Integer(1), message.getCurrent());
		
		assertTrue(message.jump(-1));
		assertEquals(new Integer(1), message.getCurrent());
	}
	
	@Test
	public void test_jumping_outside_backward() {
		assertFalse(message.jump(-1));
		assertEquals(new Integer(0), message.getCurrent());
	}
	
	@Test
	public void test_jumping_outside_forward() {
		assertFalse(message.jump(5));
		assertEquals(new Integer(0), message.getCurrent());
	}
	
	@Test
	public void test_jump() {
		message = new IncreasableOffsetList(Arrays.asList(0, 3, 0, 1, -3));
		
		assertEquals(new Integer(0), message.getCurrent());
		message.jump();
		assertEquals(new Integer(1), message.getCurrent());
		
		message.jump();
		assertEquals(new Integer(3), message.getCurrent());
		
		message.jump();
		assertEquals(new Integer(-3), message.getCurrent());
		
		message.jump();
		assertEquals(new Integer(4), message.getCurrent());
		
		assertFalse(message.jump());
	}
	
	@Test
	public void test_jump_around_until_outside() {
		message = new IncreasableOffsetList(Arrays.asList(0, 3, 0, 1, -3));
		assertEquals(5, message.jumpAround());
	}
	
	@Test
	public void test_jump_around() throws IOException {
		message = new IncreasableOffsetList(readTestData());
		assertEquals(326618, message.jumpAround());
	}
	
	@Test
	public void test_jump_around_incr_decr() throws IOException {
		message = new IncrDecrOffsetList(readTestData());
		assertEquals(21841249, message.jumpAround());
	}
	
	private List<Integer> readTestData() throws IOException {
		String filename = "data/day05/test.data";
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			return stream
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		}
	}
}
