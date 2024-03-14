package com.hackerRank.oneMonth.week.two;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrimeDates {
	public static int month[];

	public static void main(String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
//		String s = in.nextLine();
//		String s = "02-08-2025 04-09-2025";//in.nextLine();
		String s = "13-10-2323 11-10-9536";
		
		String FORMAT = "dd-MM-yyyy";
		
		StringTokenizer str = new StringTokenizer(s, " ");

		LocalDate d1 = LocalDate.parse(str.nextToken().trim(), DateTimeFormatter.ofPattern(FORMAT));
		LocalDate d2 = LocalDate.parse(str.nextToken().trim(), DateTimeFormatter.ofPattern(FORMAT));

		int result = 0;
		while (d1.isBefore(d2)) {
			int year = d1.getYear();
			int month = d1.getMonthValue();
			int day = d1.getDayOfMonth();
			String valueString = Integer.toString(day) + Integer.toString(month) + Integer.toString(year);
			int value = Integer.parseInt(valueString);
			
			if (value % 4 == 0 || value % 7 == 0) {
				result++;
			}
			d1 = d1.plusDays(1);
		}
		System.out.println(result);
		in.close();
	}
}
