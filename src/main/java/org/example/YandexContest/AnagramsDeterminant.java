package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Solution via Map
 * 224ms
 * 17.84Mb
 *
 * Solution via charArray
 * 147ms
 * 16.10Mb
 */
public class AnagramsDeterminant {
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static final String INPUT_FILE = "input.txt";
    public static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException {
        init();
        run();
        close();
    }

    public static void run() throws IOException {
        String firstLine = bufferedReader.readLine();
        String secondLine = bufferedReader.readLine();
        bufferedWriter.write(String.valueOf(isAnagrams(firstLine, secondLine)));

    }

    private static int isAnagrams(String firstLine, String secondLine) {
        if (firstLine.length() != secondLine.length()) {
            return 0;
        }

        char[] firstLIneAsCharArray = firstLine.toCharArray();
        Arrays.sort(firstLIneAsCharArray);

        char[] secondLineAsCharArray = secondLine.toCharArray();
        Arrays.sort(secondLineAsCharArray);

        if (Arrays.equals(firstLIneAsCharArray, secondLineAsCharArray)) {
            return 1;
        }
        return 0;
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
    }

    private static void close() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }
}