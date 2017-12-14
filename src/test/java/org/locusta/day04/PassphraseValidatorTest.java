package org.locusta.day04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

public class PassphraseValidatorTest {
	
	@Test
	public void test_contains_no_duplicate_words() {
		assertTrue(PassphraseValidator.validate("aa bb cc dd ee"));
		assertTrue(PassphraseValidator.validate("aa bb cc dd aaa"));
	}

	@Test
	public void test_contains_duplicate_words() {
		assertFalse(PassphraseValidator.validate("aa bb cc dd aa"));
	}
	
	@Test
	public void test_count_valid_passphrases() throws IOException {
		String filename = "data/day04/test.data";
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			assertEquals(466, stream
			.parallel()
			.filter(PassphraseValidator::validate)
			.count());
		}
	}
	
	@Test
	public void test_count_no_duplicate_words_anagram() {
		assertTrue(PassphraseValidator.validateNoAnagram("abcde fghij"));
		assertTrue(PassphraseValidator.validateNoAnagram(("iiii oiii ooii oooi oooo")));
	}
	
	@Test
	public void test_count_duplicate_anagramed_words() {
		assertFalse(PassphraseValidator.validateNoAnagram("abcde xyz ecdab"));
		assertFalse(PassphraseValidator.validateNoAnagram("oiii ioii iioi iiio"));
	}
	
	@Test
	public void test_count_valid_anagramed_words() throws IOException {
		String filename = "data/day04/test.data";
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			assertEquals(251, stream
			.parallel()
			.filter(PassphraseValidator::validateNoAnagram)
			.count());
		}
	}
}
