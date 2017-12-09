package org.locusta.day02;

import static org.junit.Assert.*;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class SpreadsheetChecksumCalcTest {
	
	private static final List<List<Integer>> SMALL_SAMPLE_SPREADSHEET = 
			asList(asList(5, 1, 9, 5), 
				   asList(7, 5, 3   ),
				   asList(2, 4, 6, 8));
	private static final List<List<Integer>> PART_TWO_SAMPLE_SPREADSHEET =
			asList(asList(5, 9, 2, 8),
				   asList(9, 4, 7, 3),
				   asList(3, 8, 6, 5));
	
	@Test
	public void test_spreadsheet_row_max_min_diff() {
		assertEquals(8, SpreadsheetChecksumCalc.substractRowMaxMin(SMALL_SAMPLE_SPREADSHEET.get(0)));
		assertEquals(4, SpreadsheetChecksumCalc.substractRowMaxMin(SMALL_SAMPLE_SPREADSHEET.get(1)));
		assertEquals(6, SpreadsheetChecksumCalc.substractRowMaxMin(SMALL_SAMPLE_SPREADSHEET.get(2)));
	}
	
	@Test
	public void test_small_spreadsheet_checksum() {
		assertEquals(18, new SpreadsheetChecksumCalc(SMALL_SAMPLE_SPREADSHEET).checksum(SpreadsheetChecksumCalc::substractRowMaxMin));
	}
	
	@Test
	public void test_spreadsheet_substraction_checksum() throws IOException {
		assertEquals(47136, new SpreadsheetChecksumCalc(SpreadsheetReader.read("test.data")).checksum(SpreadsheetChecksumCalc::substractRowMaxMin));
	}
	
	@Test
	public void test_spreadsheet_row_evenly_division_numbers() {
		assertEquals(4, SpreadsheetChecksumCalc.divideEvenlyDividedNumbers(PART_TWO_SAMPLE_SPREADSHEET.get(0)));
		assertEquals(3, SpreadsheetChecksumCalc.divideEvenlyDividedNumbers(PART_TWO_SAMPLE_SPREADSHEET.get(1)));
		assertEquals(2, SpreadsheetChecksumCalc.divideEvenlyDividedNumbers(PART_TWO_SAMPLE_SPREADSHEET.get(2)));
	}

	@Test
	public void test_spreadsheet_even_division_checksum() throws IOException {
		assertEquals(250, new SpreadsheetChecksumCalc(SpreadsheetReader.read("test.data")).checksum(SpreadsheetChecksumCalc::divideEvenlyDividedNumbers));
	}
}
