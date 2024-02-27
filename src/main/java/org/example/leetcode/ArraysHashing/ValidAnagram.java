package org.example.leetcode.ArraysHashing;

import org.example.leetcode.Task;

import java.util.Arrays;
import java.util.Map;

public class ValidAnagram implements Task {

    public static void main(String[] args) {
        System.out.println(isAnagram("catp", "tacl"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] firstString = s.toCharArray();
        char[] secondString = t.toCharArray();

        Arrays.sort(firstString);
        Arrays.sort(secondString);

        return Arrays.equals(firstString, secondString);
    }

    private static void putCharIntoMapAndCountIt(Map<Character, Integer> firstLineMap, char characterInFirstLine) {
        int countOfCharacterInFirstLine = firstLineMap.getOrDefault(characterInFirstLine, 0);
        firstLineMap.put(characterInFirstLine, countOfCharacterInFirstLine + 1);
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-anagram/description/";
    }

    @Override
    public void getMySolution() {//Time complexity O(t.length + s.length) because we have to iterate through both of the strings
        //Memory complexity is the same because we are building two hash maps

//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> firstLineMap = new HashMap<>();
//        Map<Character, Integer> secondLineMap = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char characterInFirstLine = s.charAt(i);
//            putCharIntoMapAndCountIt(firstLineMap, characterInFirstLine);
//
//            char characterInSecondLine = t.charAt(i);
//            putCharIntoMapAndCountIt(secondLineMap, characterInSecondLine);
//        }
//
//        for (Character firstLineKey : firstLineMap.keySet()) {
//            if (!firstLineMap.get(firstLineKey).equals(secondLineMap.get(firstLineKey))) {
//                return false;
//            }
//        }
//        return true;
    }

    @Override
    public void getOptimizeSolution() {
//        if (s.length() != t.length()) {
//            return false;
//        }

//        char[] firstString = s.toCharArray();
//        char[] secondString = t.toCharArray();
//
//        Arrays.sort(firstString);
//        Arrays.sort(secondString);
//
//        return Arrays.equals(firstString, secondString);
    }

    @Override
    public String getTimeComplexity() {
        return "O(nlogn)"; //because we need to sort our arrays
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";//constant extra memory if we have good sorting algorithms. And it can be O(n)
    }
}
