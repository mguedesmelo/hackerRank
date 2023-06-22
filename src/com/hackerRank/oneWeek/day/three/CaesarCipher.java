package com.hackerRank.oneWeek.day.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultCaesarCipher {
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static String caesarCipher(String s, int k) {
        char sarr[] = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            sarr[i] = encrypt(sarr[i], k);
        }
        return new String(sarr);
    }
    
    public static char encrypt(char c, int shift) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        char base = 'A';
        if (c >= 'a') {
            base = 'a';
        }
        return (char)(((c - base + shift) % 26) + base);
    }
}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultCaesarCipher.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
