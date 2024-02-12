package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    private static Map<Character, Integer> countCharactersInLine(String contentLine) {
        Map<Character, Integer> countCharactersInLineMap = new HashMap<>();
        for (int i = 0; i < contentLine.length(); i++) {
            char contentLineCharacter = contentLine.charAt(i);
            int countOfCharacter = countCharactersInLineMap.getOrDefault(contentLineCharacter, 0);
            countCharactersInLineMap.put(contentLineCharacter, countOfCharacter + 1);
        }
        return countCharactersInLineMap;
    }

    private static int isAnagrams(String firstLine, String secondLine) {
        if (firstLine.length() != secondLine.length()) {
            return 0;
        }

        Map<Character, Integer> firstLineCharsAndCountsMap = countCharactersInLine(firstLine);
        Map<Character, Integer> secondLineCharsAndCountsMap = countCharactersInLine(secondLine);

        if (!firstLineCharsAndCountsMap.equals(secondLineCharsAndCountsMap)) {
            return 0;
        }

        return 1;
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