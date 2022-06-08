package com.lt.crs.utils;

import java.util.Arrays;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {

	public static void printStatement(String msg) {
		System.out.println(msg);
	}
	
//	public static void simpleTable() {
//		 
//		/*
//		 * leftJustifiedRows - If true, it will add "-" as a flag to format string to
//		 * make it left justified. Otherwise right justified.
//		 */
//		boolean leftJustifiedRows = false;
//	 
//		/*
//		 * Table to print in console in 2-dimensional array. Each sub-array is a row.
//		 */
//		String[][] table = new String[][] { { "id", "First Name", "Last Name", "Age" },
//				{ "1", "John", "Johnson", "45" }, { "2", "Tom", "", "35" }, { "3", "Rose", "Johnson", "22" },
//				{ "4", "Jimmy", "Kimmel", "" } };
//	 
//		/*
//		 * Calculate appropriate Length of each column by looking at width of data in
//		 * each column.
//		 * 
//		 * Map columnLengths is <column_number, column_length>
//		 */
//				
//		Map<Integer, Integer> columnLengths = new HashMap<>();
//		Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
//			if (columnLengths.get(i) == null) {
//				columnLengths.put(i, 0);
//			}
//			if (columnLengths.get(i) < a[i].length()) {
//				columnLengths.put(i, a[i].length());
//			}
//		}));
//		System.out.println("columnLengths = " + columnLengths);
//	 
//		/*
//		 * Prepare format String
//		 */
//		final StringBuilder formatString = new StringBuilder("");
//		String flag = leftJustifiedRows ? "-" : "";
//		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
//		formatString.append("|\n");
//		System.out.println("formatString = " + formatString.toString());
//	 
//		/*
//		 * Print table
//		 */
//		Stream.iterate(0, (i -> i < table.length), (i -> ++i))
//				.forEach(a -> System.out.printf(formatString.toString(), table[a]));
//	 
//	}
	
	public static String generateRefNumber() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999) + 1000000000;
		return String.format("REF%10d", number);
	}
	
}
