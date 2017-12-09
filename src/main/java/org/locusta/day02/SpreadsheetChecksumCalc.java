package org.locusta.day02;

import java.util.Collections;
import java.util.List;
import java.util.function.ToIntFunction;

public class SpreadsheetChecksumCalc {

	private final List<List<Integer>> spreadsheet;

	public SpreadsheetChecksumCalc(List<List<Integer>> spreadsheet) {
		this.spreadsheet = spreadsheet;
	}

	public static int substractRowMaxMin(List<Integer> row) {
		return Collections.max(row) - Collections.min(row); 
	}

	public int checksum(ToIntFunction<? super List<Integer>> function) {
		return spreadsheet
				.stream()
				.mapToInt(function)
				.sum();
	}

	public static int divideEvenlyDividedNumbers(List<Integer> row) {
		for (int i=0; i < row.size(); i++) {
			for (int j=0; j < row.size(); j++) {
				if (i != j) {
					if (row.get(i) % row.get(j) == 0) {
						return row.get(i) / row.get(j);
					}
				}
			}
		}
			
		return 0;
	}

}
