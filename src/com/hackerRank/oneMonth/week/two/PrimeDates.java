package com.hackerRank.oneMonth.week.two;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrimeDates {
	public static int month[];

	public static void main(String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		
		StringTokenizer str = new StringTokenizer(s, " ");
		String d1 = str.nextToken().trim();
		String d2 = str.nextToken().trim();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date firstDate = formatter.parse(d1);
		Date secondDate = formatter.parse(d2);

		int result = 0;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatterLeadingZeroes = new SimpleDateFormat("dMMyyyy");
		while (true) {
			int value = Integer.parseInt(formatterLeadingZeroes.format(firstDate));
			if (value % 4 == 0 || value % 7 == 0) {
				result++;
			}
			c.setTime(firstDate);
			c.add(Calendar.DATE, 1);
			firstDate = c.getTime();
			if (firstDate.after(secondDate)) {
				break;
			}
		}
		System.out.println(result);
//		02-08-2025 04-09-2025
		in.close();
	}
}
