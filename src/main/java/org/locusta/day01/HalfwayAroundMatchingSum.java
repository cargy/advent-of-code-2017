package org.locusta.day01;

import org.locusta.util.IntArrayUtil;

public class HalfwayAroundMatchingSum {

	private final int[] digits;

	public HalfwayAroundMatchingSum(String digits) {
		this.digits = IntArrayUtil.toIntArray(digits);
	}
	
	public int getSum() {
		int sum = 0;
		for (int i=0; i < digits.length; i++) {
			if (getDigit(i) == getDigit(i + (digits.length / 2))) {
				sum += getDigit(i);
			}
			
		}
		return sum;
	}
	
	/**
	 * e.x. "1234".length = 4
	 *      4 % 4 = 0
	 *      5 % 4 = 1
	 *      6 % 4 = 2
	 *      7 % 4 = 3
	 *      3 % 4 = 3
	 */
	public int getDigit(int index) {
		if (index < digits.length) {
			return digits[index];
		} else {
			return digits[index % digits.length];
		}
	}

}
