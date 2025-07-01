package org.example.leetcode.Medium;

import org.example.leetcode.Task;

import java.util.HashSet;

public class StringCompression implements Task {

    public static int compress(char[] chars) {
        int indexOfCompressedArray = 0;
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            int countOfConsecutiveChar = 0;

            while (i < chars.length && letter == chars[i]) {
                countOfConsecutiveChar++;
                i++;
            }

            chars[indexOfCompressedArray++] = letter;

            if (countOfConsecutiveChar > 1) {
                for (char countChar : String.valueOf(countOfConsecutiveChar).toCharArray()) {
                    chars[indexOfCompressedArray++] = countChar;
                }
            }
        }
        return indexOfCompressedArray;
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
//        public static int compress(char[] chars) {
//            int indexOfCompressedArray = 0;
//            for (int i = 0; i < chars.length;) {
//                char letter = chars[i];
//                int countOfConsecutiveChar = 0;
//
//                while (i < chars.length && letter == chars[i]) {
//                    countOfConsecutiveChar++;
//                    i++;
//                }
//
//                chars[indexOfCompressedArray++] = letter;
//
//                if (countOfConsecutiveChar > 1) {
//                    for (char countChar : String.valueOf(countOfConsecutiveChar).toCharArray()) {
//                        chars[indexOfCompressedArray++] = countChar;
//                    }
//                }
//            }
//            return indexOfCompressedArray;
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
