package org.locusta.day01;

import org.locusta.util.IntArrayUtil;

public class NextMatchingDigitSum {
	
	private final int[] digits;

	public NextMatchingDigitSum(String digits) {
		this.digits = IntArrayUtil.toIntArray(digits);
	}
	
	public NextMatchingDigitSum(int[] digits) {
		this.digits = digits;
	}
	
	public int getSum() {
		int n = digits.length - 1;
		return matchingDigitsSum(digits, n);
	}

	private int matchingDigitsSum(int[] digits, int index) {
		if (index < 0) {
			return 0;
		} else if (index >= digits.length - 1) {
			return matchingDigitsSum(digits, index, 0);
		} else {
			return matchingDigitsSum(digits, index, index+1);
		}
	}
	
	private int matchingDigitsSum(int[] digits, int indexA, int indexB) {
		if (digits[indexA] == digits[indexB]) {
			return matchingDigitsSum(digits, indexA -1) + digits[indexA];
		} else {
			return matchingDigitsSum(digits, indexA -1);
		}
	}
	
//	private static int[] toIntArray(String string) {
//		int[] digits = new int[string.length()];
//		char[] chars = string.toCharArray();
//		
//		for (int i = 0; i < chars.length; i++) {
//			digits[i] = Character.getNumericValue(chars[i]);
//		}
//		
//		return digits;
//	}
	
}
