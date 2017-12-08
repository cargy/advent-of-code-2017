package org.locusta.day01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextMatchingDigitSumTest {
	
	@Test
	public void test_captcha_two_matching() {
		assertEquals(3, new NextMatchingDigitSum("1122").getSum());
	}
	@Test
	public void test_captcha_four_matching() {
		assertEquals(4, new NextMatchingDigitSum("1111").getSum());
	}
	
	@Test
	public void test_captcha_none_matching() {
		assertEquals(0, new NextMatchingDigitSum("1234").getSum());
	}
	
	@Test
	public void test_all_digits_sum() {
		assertEquals(9, new NextMatchingDigitSum("91212129").getSum());
	}
	
	@Test
	public void test_captcha() {
		assertEquals(1177, new NextMatchingDigitSum(TestData.CAPTCHA).getSum());
	}

}
