package org.locusta.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpreadsheetReader {
	
	public static List<List<Integer>> read(String filename) throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			return stream
					.map((line) -> {
						return Arrays.asList(line.split("\t"))
								.stream()
								.mapToInt(Integer::parseInt)
								.boxed()
								.collect(Collectors.toList());
					})
					.collect(Collectors.toList());
		}
	}
	
}
