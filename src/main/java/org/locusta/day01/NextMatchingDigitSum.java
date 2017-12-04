package org.locusta.day01;

public class NextMatchingDigitSum {
	
	private final int[] digits;

	public NextMatchingDigitSum(String digits) {
		this.digits = toIntArray(digits);
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
		} else if (index +1 >= digits.length) {
			if (digits[index] == digits[0]) {
				return matchingDigitsSum(digits, index -1) + digits[index];
			} else {
				return matchingDigitsSum(digits, index -1);
			}
		} else if (digits[index] == digits[index+1]) {
			return matchingDigitsSum(digits, index - 1) + digits[index];
		} else {
			return matchingDigitsSum(digits, index - 1);
		}
	}
	
	private static int[] toIntArray(String string) {
		int[] digits = new int[string.length()];
		char[] chars = string.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			digits[i] = Character.getNumericValue(chars[i]);
		}
		
		return digits;
	}
	
}
