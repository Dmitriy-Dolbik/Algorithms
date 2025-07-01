package org.example.leetcode.Medium;

import org.example.leetcode.Task;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters implements Task {

    public static int lengthOfLongestSubstring(String s) {
        int[] charIndexesArray = new int[128];
        Arrays.fill(charIndexesArray, -1);
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int currentChar = s.charAt(right);
            if (charIndexesArray[currentChar] < left) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charIndexesArray[currentChar] + 1;
            }
            charIndexesArray[currentChar] = right;
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
        //Second optimal solution via Map
//        public static int lengthOfLongestSubstring(String s) {
//            Map<Character, Integer> map = new HashMap<>();
//            int left = 0;
//            int maxLength = 0;
//
//            for (int right = 0; right < s.length(); right++) {
//                char currentChar = s.charAt(right);
//                if (!map.containsKey(currentChar) || map.get(currentChar) < left) {
//                    maxLength = Math.max(maxLength, right - left + 1);
//                } else {
//                    left = map.get(currentChar) + 1;
//                }
//                map.put(currentChar, right);
//            }
//            return maxLength;
//        }
//        }
//        Third optimal solution via int array
//        public static int lengthOfLongestSubstring(String s) {
//            int[] charIndexesArray = new int[128];
//            Arrays.fill(charIndexesArray, -1);
//            int maxLength = 0;
//            int left = 0;
//
//            for (int right = 0; right < s.length(); right++) {
//                int currentChar = s.charAt(right);
//                if (charIndexesArray[currentChar] < left) {
//                    maxLength = Math.max(maxLength, right - left + 1);
//                } else {
//                    left = charIndexesArray[currentChar] + 1;
//                }
//                charIndexesArray[currentChar] = right;
//            }
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
        return " O(k), где k - количество уникальных символов";
    }
}
