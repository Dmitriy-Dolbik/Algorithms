package org.example.leetcode.Medium;

import org.example.leetcode.Task;

public class StringCompression implements Task {

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int countOfCharacters = 0;
        int indexOfLastCount = -1;
        int sameCharCount = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            char current = chars[i];
            char next = chars[i + 1];
            if (current == next) {
                sameCharCount++;
            } else if (sameCharCount != 1) {
                chars[indexOfLastCount + 2] = (char) (sameCharCount + '0');
                indexOfLastCount += 2;
                countOfCharacters++;
                sameCharCount = 1;
            } else {
                indexOfLastCount += 1;
                countOfCharacters++;
            }
        }
        if (sameCharCount > 1) {
            chars[indexOfLastCount + 2] = (char) (sameCharCount + '0');
            countOfCharacters++;
        }
        return countOfCharacters * 2;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/string-compression/description/";
    }

    @Override
    public void getMySolution() {

    }

    @Override
    public void getOptimizeSolution() {

    }

    @Override
    public String getTimeComplexity() {
        return "";
    }

    @Override
    public String getSpaceComplexity() {
        return "";
    }
}
