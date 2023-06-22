package com.hackerRank.oneWeek.day.one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultTimeConversion {
	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */
	public static String timeConversion(String s) {
		String timeParts[] = s.split(":");
		String hour = timeParts[0];
		String minutes = timeParts[1];
		String seconds = timeParts[2].substring(0, 2);
		String text = timeParts[2].substring(2, 4).toUpperCase();
		if ("AM".equals(text)) {
			if ("12".equals(hour)) {
				hour = "00";
			}
		} else {
			if (!"12".equals(hour)) {
				int h = Integer.parseInt(hour);
				h += 12;
				hour = Integer.toString(h);
			}
		}
		return hour + ":" + minutes + ":" + seconds;
	}
}

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = ResultTimeConversion.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
