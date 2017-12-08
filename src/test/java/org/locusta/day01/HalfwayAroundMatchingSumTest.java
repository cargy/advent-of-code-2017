package org.locusta.day01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HalfwayAroundMatchingSumTest {
	
	@Test
	public void test_get_digit() {
		assertEquals(3, new HalfwayAroundMatchingSum("1234").getDigit(2));
	}
	
	@Test
	public void test_get_circualr_digit() {
		assertEquals(2, new HalfwayAroundMatchingSum("1234").getDigit(5));
	}
	
	@Test
	public void test_halfway_around_sum_1212() {
		assertEquals(6, new HalfwayAroundMatchingSum("1212").getSum());
	}

	@Test
	public void test_halfway_around_sum_123425() {
		assertEquals(4, new HalfwayAroundMatchingSum("123425").getSum());
	}

	@Test
	public void test_halfway_around_sum_123123() {
		assertEquals(12, new HalfwayAroundMatchingSum("123123").getSum());
	}
	
	@Test
	public void test_halfway_around_sum_12131415() {
		assertEquals(4, new HalfwayAroundMatchingSum("12131415").getSum());
	}
	
	@Test
	public void test_captcha() {
		assertEquals(1060, new HalfwayAroundMatchingSum(TestData.CAPTCHA).getSum());
	}
}
