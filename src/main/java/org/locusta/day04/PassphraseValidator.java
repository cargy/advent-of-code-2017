package org.locusta.day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PassphraseValidator {

	public static boolean validate(String passphrase) {
		Set<String> words = new HashSet<>();
		for (String word : passphrase.split(" ")) {
			if (!words.add(word)) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean validateNoAnagram(String passphrase) {
		Set<String> words = new HashSet<>();
		for (String word : passphrase.split(" ")) {
			if (!words.add(sortedLetters(word))) {
				return false;
			}
		}
		return true;
	}
	
	private static String sortedLetters(String passphrase) {
		char[] words = passphrase.toCharArray();
		Arrays.sort(words);
		return new String(words);
	}

}
