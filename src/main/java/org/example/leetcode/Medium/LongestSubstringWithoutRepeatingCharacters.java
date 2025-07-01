package org.example.leetcode.Medium;

import org.example.leetcode.Task;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters implements Task {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkewp"));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/longest-substring-without-repeating-characters/description/";
    }

    @Override
    public void getMySolution() {
//        public static int lengthOfLongestSubstring(String s) {
//            Set<Character> charSet = new HashSet<>();
//            int maxSubseqCount = 0;
//            for (int i = 0; i < s.length();) {
//                while (i < s.length() && !charSet.contains(s.charAt(i))) {
//                    charSet.add(s.charAt(i));
//                    i++;
//                }
//
//                maxSubseqCount = Math.max(maxSubseqCount, charSet.size());
//                i = i - charSet.size() + 1;
//                charSet = new HashSet<>();
//            }
//            maxSubseqCount = Math.max(maxSubseqCount, charSet.size());
//            return maxSubseqCount;
//        }
        //Second optima solution via Map
//        public static int lengthOfLongestSubstring(String s) {
//            int n = s.length();
//            int maxLength = 0;
//            Map<Character, Integer> charMap = new HashMap<>();
//            int left = 0;
//
//            for (int right = 0; right < n; right++) {
//                if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
//                    charMap.put(s.charAt(right), right);
//                    maxLength = Math.max(maxLength, right - left + 1);
//                } else {
//                    left = charMap.get(s.charAt(right)) + 1;
//                    charMap.put(s.charAt(right), right);
//                }
//            }
//
//            return maxLength;
//        }
    }

    @Override
    public void getOptimizeSolution() {

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
