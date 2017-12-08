package org.locusta.util;

public class IntArrayUtil {
	
	public static int[] toIntArray(String string) {
		int[] digits = new int[string.length()];
		char[] chars = string.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			digits[i] = Character.getNumericValue(chars[i]);
		}
		
		return digits;
	}

}
